package michal.kiecana.assignment.repositories;

import michal.kiecana.assignment.domain.RandomNumber;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomNumberRepository extends PagingAndSortingRepository<RandomNumber, Long> {
}
