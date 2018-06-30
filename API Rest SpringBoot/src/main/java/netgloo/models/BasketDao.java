package netgloo.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface BasketDao extends CrudRepository<Basket, Long>{
	public Basket findByName(String name);
}
