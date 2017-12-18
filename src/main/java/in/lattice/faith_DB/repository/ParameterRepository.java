package in.lattice.faith_DB.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.lattice.faith.restapi.dto.Parameter;

public interface ParameterRepository extends PagingAndSortingRepository<Parameter, Integer> {

}
