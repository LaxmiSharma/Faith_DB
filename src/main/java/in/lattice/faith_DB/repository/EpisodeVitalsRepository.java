package in.lattice.faith_DB.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.lattice.faith.restapi.dto.Episode;

public interface EpisodeVitalsRepository extends PagingAndSortingRepository<Episode, Long> {

}
