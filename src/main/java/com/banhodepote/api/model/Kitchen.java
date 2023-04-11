import org.springframework.beans.factory.annotation.Autowired;

import com.banhodepote.api.dto.ItemDTO;
import com.banhodepote.api.repository.ItemsRepository;

public class Kitchen{

    private Number typeKitchen;
    
    @Autowired
    ItemsRepository itemsRepository;

    public void createItem(ItemDTO data){

        Items newDish = new Items(data);
        itemsRepository.save(newDish);

    }
   

}