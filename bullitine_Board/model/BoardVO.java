package www.dream.bullitine_Board.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import www.dream.framework.model.Entity;

@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BoardVO extends Entity {
	private String name;
	private String descrip;
	private long postCnt = 0; // '총 게시물 개수', long 의 기본 값은 0이라 없어도 된다.

	public BoardVO(String id) {
		super(id);
	}
	
	/** 사용자로 부터 (매니저로 부터) 정보가 만들어질때 사용할거야(활용할거야) */
	public BoardVO(String name, String descrip) {
		this.name = name;
		this.descrip = descrip;
	}

	@Override
	public String toString() {
		return "BoardVO [" + super.toString() + ", name=" + name + ", descrip=" + descrip + ", postCnt=" + postCnt + "]";
	}

}