package org.example;

import java.util.List;

public class CategoryDto extends CategoryEntity{
    public List<CategoryEntity> child;
    public CategoryEntity parent;

    public CategoryDto(CategoryEntity data) {
        super(data.idx, data.name, data.depth, data.parentIdx);
    }
}
