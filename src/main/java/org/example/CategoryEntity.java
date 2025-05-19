package org.example;

public class CategoryEntity {
    public int idx;
    public String name;
    public int depth;
    public Integer parentIdx;

    public CategoryEntity(int idx, String name, int depth, Integer parentIdx){
        this.idx = idx;
        this.name = name;
        this.depth = depth;
        this.parentIdx = parentIdx;
    }
}