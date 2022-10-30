package com.example.shoponline.Repository;

import com.example.shoponline.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("select count(p.category.id) as countProd,c.categoryName,c.id as categoryId from Category as c left join Product  as p on (c.id=p.category.id) group by c.id ")
    List<Object> getCategoryData();
    @Query("from Category as c where c.active=:active ")
    List<Category> getCategoriesByActive(@Param("active") Boolean active);

}
