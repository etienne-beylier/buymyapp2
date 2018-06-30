package netgloo.models;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

@Transactional
public interface ShopDao extends CrudRepository<Shop, Long>  {
	public Shop findByName(String name);
}
