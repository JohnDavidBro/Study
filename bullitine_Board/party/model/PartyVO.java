package www.dream.bullitine_Board.party.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Getter;
import lombok.NoArgsConstructor;
import www.dream.framework.model.MasterEntity;

@Getter
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
/** id 값 Entity <= reg_dt, upt_dt 값 MasterEntity 상속. id와 dt값을 위해 */
public abstract class PartyVO extends MasterEntity { 
	private String name;
	private boolean gender;  //boolean comment '0이면 여자, 1이면 남자.
	
	private List<ContectPointVO> listContectPoint; // 연락처 목록

	public PartyVO(String id) {
		super(id);
	}
	
	public PartyVO(String name, boolean gender) {
		this.name = name;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}

	public List<ContectPointVO> getListContectPoint() {
		return listContectPoint;
	}

	public void addCP(ContectPointVO cp) {
		listContectPoint.add(cp);
	}
	
	@Override
	public String toString() {
		return super.toString() + ", name=" + name + ", gender=" + gender + "연락처들=" + listContectPoint;
	}

}