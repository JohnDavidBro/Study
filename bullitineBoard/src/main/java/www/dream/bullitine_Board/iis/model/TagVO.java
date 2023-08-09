package www.dream.bullitine_Board.iis.model;

/** iis Inverted Index Search / Index : 데이터에서 역으로 목차로 간다. 검색 기능 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Table(name = "T_Tag")
@AllArgsConstructor
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
/** Tag정보. */
public class TagVO {
	@Id
	private String id;
	private String word;
	@Column(name = "description")
	private String wde; // 단어정의설명 word definition explanation
	private long df; // 'document frequency, 문서빈도'

	public TagVO() {}
	
	public TagVO(String word, String wde) {
		this.word = word;
		this.wde = wde;
	}

	public void setId(String id) {
		this.id = id;
	}
}
