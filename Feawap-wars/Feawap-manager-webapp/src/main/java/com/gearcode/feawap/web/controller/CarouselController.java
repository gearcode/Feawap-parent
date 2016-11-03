package com.gearcode.feawap.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gearcode.feawap.domain.Carousel;
import com.gearcode.feawap.domain.CarouselExample;
import com.gearcode.feawap.persistence.CarouselMapper;
import com.gearcode.feawap.util.FileUploadUtils;

@Controller
@RequestMapping("/carousel")
public class CarouselController {

    private static final Log logger = LogFactory.getLog(CarouselController.class);

    @Value("${upload.root}")
    private String uploadRoot;
    
    @Value("${upload.preview}")
    private String uploadPreview;
    
    @Resource
    private CarouselMapper carouselMapper;

	@RequestMapping()
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		CarouselExample example = new CarouselExample();
		example.setOrderByClause("sort asc, created desc");
		List<Carousel> list = carouselMapper.selectByExample(example);
		request.setAttribute("list", list);
		return "carousel/index";
	}

	@RequestMapping("record")
	public String record(HttpServletRequest request) {
		int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(id > 0) {
			Carousel carousel = carouselMapper.selectByPrimaryKey(id);
			request.setAttribute("record", carousel);
		}
		return "carousel/record";
	}
	
	@RequestMapping("save")
	@ResponseBody
	public Object save(final MultipartHttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		final String title = ServletRequestUtils.getStringParameter(request, "title", "");
		final String url = ServletRequestUtils.getStringParameter(request, "url", "");
		MultipartFile pic = request.getFile("pic");

		Carousel record = new Carousel(){{
			setTitle(title);
			setUrl(url);
		}};
		
		/*
		 * 上传图片
		 */
		if(pic != null) {
			try {
				String dir = "/carousel";
				//上传
				String fileName = FileUploadUtils.uploadRandomName(pic, uploadRoot + dir);
				//设置路径
				record.setPic(dir + "/" + fileName);
			} catch (IllegalStateException e) {
				logger.error(e);
			} catch (IOException e) {
				logger.error(e);
			}
		}
		
		if(id > 0) {
			/*
			 * 修改
			 */
			carouselMapper.updateByExampleSelective(record, new CarouselExample(){{
				createCriteria().andIdEqualTo(id);
			}});
		} else {
			/*
			 * 新增
			 */
			List<Carousel> lastRecord = carouselMapper.selectByExampleWithRowbounds(new CarouselExample(){{
				setOrderByClause("sort desc");
			}}, new RowBounds(0, 1));
			if(lastRecord == null || lastRecord.size() == 0) {
				record.setSort(1);
			} else {
				record.setSort(lastRecord.get(0).getSort() + 1);
			}
			record.setCreated(new Date());
			carouselMapper.insert(record);
		}
		return "success";
	}

	@RequestMapping("delete")
	public String delete(HttpServletRequest request) {
		final int id = ServletRequestUtils.getIntParameter(request, "id", -1);
		if(id > 0) {
			carouselMapper.deleteByPrimaryKey(id);
		}
		return "redirect:/action/carousel";
	}
}
