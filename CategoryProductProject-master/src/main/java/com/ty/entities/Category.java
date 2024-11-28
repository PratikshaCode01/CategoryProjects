package com.ty.entities;



import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import com.ty.entities.*;
@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	@OneToMany(mappedBy = "category" , cascade = CascadeType.ALL)
	private List<Product> products;
}
