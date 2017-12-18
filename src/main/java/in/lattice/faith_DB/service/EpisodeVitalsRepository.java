package in.lattice.faith_DB.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import in.lattice.faith.decoder.bean.Packet;
import in.lattice.faith_DB.dto.EpisodeVitals;

public interface EpisodeVitalsRepository extends PagingAndSortingRepository<EpisodeVitals, Long> {
	
}
