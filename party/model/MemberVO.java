package www.dream.party.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberVO extends PartyVO {

	public MemberVO(String name, boolean gender) {
		super(name, gender);
	}

	@Override
	public String toString() {
		return "MemberVO [" + super.toString() + "]";
	}

}
