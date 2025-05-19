package org.example;

import java.util.List;

public class CategoryDto extends CategoryEntity{
    public List<CategoryDto> child;
    public CategoryDto(CategoryEntity data) {
        super(data.idx, data.name, data.depth, data.parentIdx);
    }
}
