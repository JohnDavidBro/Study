package www.dream.framework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
/** Object를 상속한다. */
public abstract class Entity {
	//id = (primitive type의 경우 기본값. reference type의 경우) null
	private String id;
	
	@Override
	public String toString() {
		return "id=" + id;
	}

	
}