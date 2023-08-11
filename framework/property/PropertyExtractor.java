package www.dream.framework.property;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import www.dream.bullitine_Board.model.PostVO;
import www.dream.bullitine_Board.party.model.MemberVO;
import www.dream.framework.property.anno.TargetProperty;

public class PropertyExtractor {
	private static List<Field> collectAllField(Class<?> cls) {
		List<Field> ret = new ArrayList<>();
		do {
			Arrays.stream(cls.getDeclaredFields()).forEach(f -> ret.add(f));
			cls = cls.getSuperclass();
		} while (cls != Object.class);
		return ret;
		//PostVo, ReplyVO, MasterEntity, Entity 내에 모든 값이 반복해서 돌면서 ret에 다 담김.
	}

	/**
	 * String 속성 중 @TargetProperty 이 달린 값을 추출해주는 기능. Associated 속성까지 재귀적 탐색
	 * @param obj
	 * @param ret
	 * @throws Exception
	 */
	public static void extractorProperty(Object obj, List<String> ret) throws Exception {
		List<Field> fields = collectAllField(obj.getClass()); //obj = 포스트, ret 처음엔 텅텅 빈 애
		for (Field field : fields) {
			TargetProperty dis = field.getAnnotation(TargetProperty.class);
			if (dis != null) {
					field.setAccessible(true);
					if (field.getType() == String.class) {
						// null? Class obj?
						ret.add((String) field.get(obj)); // obj (한명을 부름)
				} else {
					extractorProperty(field.get(obj), ret);
				}

			}
		}
	}

	/**
	 * 재귀 호출 준비 단계
	 * @param obj
	 * @return
	 */
	public static List<String> extractorProperty(Object obj) {
		List<String> ret = new ArrayList<>();
		try {
			extractorProperty(obj, ret);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}
	/**
	 * 타이틀, 컨텐츠 정보를 주고 그걸 작성자를 길동이란 맴버라 하고, 내가 관심 있는 모든 것에 문장 줘봐라.
	 * @param args
	 */
	public static void main(String[] args) {
		PostVO tgt = new PostVO();
		tgt.setTitle("null");
		tgt.setContent("ccc null");
		MemberVO writer = new MemberVO("길동이", true);
		tgt.setWriter(writer);

		List<String> rrr = extractorProperty(tgt);
		for (String s : rrr)
			System.out.println(s);
	}
}
