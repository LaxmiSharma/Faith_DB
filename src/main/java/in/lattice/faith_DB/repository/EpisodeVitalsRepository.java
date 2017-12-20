package in.lattice.faith_DB.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import in.lattice.faith_DB.dto.EpisodeVitals;
@Repository
public interface EpisodeVitalsRepository extends PagingAndSortingRepository<EpisodeVitals, Long> {

}
