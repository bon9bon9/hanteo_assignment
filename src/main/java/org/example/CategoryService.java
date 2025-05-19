package org.example;

import org.example.CategoryEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryService {
    private List<CategoryEntity> data;
    private Map<Integer, CategoryEntity> indexByIdx;
    private Map<String, List<CategoryEntity>> indexByName;
    private Map<Integer, List<CategoryEntity>> indexByParentIdx;
    public List<CategoryEntity> getByIdx(Integer idx){
        CategoryEntity result = indexByIdx.get(idx);
        List<CategoryEntity> returnData = new ArrayList<>();
        returnData.add(result);
        return returnData;
    }

    public List<CategoryEntity> getByName(String name){
        return indexByName.get(name);
    }

    public List<CategoryDto> addDetail(List<CategoryEntity> results){
        List<CategoryDto> returnDatas = new ArrayList<>();
        for (CategoryEntity result: results){
            CategoryDto dto = _getAllChild(result);
            returnDatas.add(dto);
        }
        return returnDatas;
    }

    private CategoryDto _getAllChild(CategoryEntity entity){
        CategoryDto dto = new CategoryDto(entity);
        List<CategoryDto> childDtoList = new ArrayList<>();
        List<CategoryEntity> child = indexByParentIdx.get(dto.idx);
        if(child != null){
            for(CategoryEntity c : child){
                 childDtoList.add(_getAllChild(c));
            }
        }
        dto.child = childDtoList;
        return dto;
    }
    public void setTestData(){
        List<CategoryEntity> testData = new ArrayList<>();
        testData.add(new CategoryEntity(1,"남자", 1, null));
        testData.add(new CategoryEntity(2, "여자", 1, null));
        testData.add(new CategoryEntity(3,"엑소", 2, 1));
        testData.add(new CategoryEntity(4,"방탄소년단", 2, 1));
        testData.add(new CategoryEntity(5,"블랙핑크", 2, 2));
        testData.add(new CategoryEntity( 6, "공지사항", 3, 3));
        testData.add(new CategoryEntity( 7, "첸", 3, 3));
        testData.add(new CategoryEntity( 8, "백현", 3, 3));
        testData.add(new CategoryEntity( 9, "시우민", 3, 3));
        testData.add(new CategoryEntity( 10, "공지사항", 3, 4));
        testData.add(new CategoryEntity( 11, "익명게시판", 3, 4));
        testData.add(new CategoryEntity( 12, "뷔", 3, 4));
        testData.add(new CategoryEntity( 13, "공지사항", 3, 5));
        testData.add(new CategoryEntity( 14, "익명게시판", 3, 5));
        testData.add(new CategoryEntity( 15, "로제", 3, 5));
        this.data = testData;
    }
    public void indexIdx(){
        Map<Integer, CategoryEntity> indexDatas = new HashMap<Integer, CategoryEntity>();
        for(CategoryEntity originData : data){
            indexDatas.put(originData.idx, originData);
        }
        this.indexByIdx = indexDatas;
    }

    public void indexName(){
        Map<String, List<CategoryEntity>> indexDatas = new HashMap<String, List<CategoryEntity>>();
        for(CategoryEntity originData : data){
            List<CategoryEntity> listData = indexDatas.get(originData.name);
            if(listData == null){
                listData = new ArrayList<>();
            }
            listData.add(originData);
            indexDatas.put(originData.name, listData);
        }
        this.indexByName = indexDatas;
    }

    public void indexParentIdx(){
        Map<Integer, List<CategoryEntity>> indexDatas = new HashMap<Integer, List<CategoryEntity>>();
        for(CategoryEntity originData : data){
            List<CategoryEntity> listData = indexDatas.get(originData.parentIdx);
            if(listData == null){
                listData = new ArrayList<>();
            }
            listData.add(originData);
            indexDatas.put(originData.parentIdx, listData);
        }
        this.indexByParentIdx = indexDatas;
    }
}
