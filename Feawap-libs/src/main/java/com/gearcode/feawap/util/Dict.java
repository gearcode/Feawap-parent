package com.gearcode.feawap.util;

import com.gearcode.feawap.util.Dict.Train.Type;

public class Dict {

	public static class Train {
		
		public static enum Type {
			Online(1, "线上培训"), Offline(2, "线下培训"), Seminars(3, "专题研讨会");
			
			private String name;
			private Integer value;

			Type(Integer value, String name) {
				this.name = name;
				this.value = value;
			}
			
			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}
			
			public Integer getValue() {
				return value;
			}

			public void setValue(Integer value) {
				this.value = value;
			}

			public static Type valueOf(Integer value) {
				Type[] values = values();
				for (Type type : values) {
					if(type.getValue().equals(value)) {
						return type;
					}
				}
				return null;
			}
		}
		
	}
	
	public static void main(String[] args) {
		Type valueOf = Train.Type.valueOf(33);
		System.out.println(valueOf);
	}
}
