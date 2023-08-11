package www.dream.bullitine_Board.party.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ManagerVO extends PartyVO {


	public ManagerVO(String name, boolean gender) {
		super(name, gender);
	}
	
	@Override
	public String toString() {
		return "ManagerVO [" + super.toString() + "]";
	}
	
}
