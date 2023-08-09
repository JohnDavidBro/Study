package www.dream.bullitine_Board.iis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import www.dream.bullitine_Board.iis.model.TagVO;

/** Mapper와 같은 역활 */
public interface TagRepository extends JpaRepository<TagVO, String> {
	@Query(value = "select NEXT_PK(:idType)", nativeQuery = true)
	String getId(@Param("idType") String idType);
}