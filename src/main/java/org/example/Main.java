package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        // 문제 1. 카테고리 자료구조화 문제
        CategoryService categoryService = new CategoryService();
        // 전체 테스트 데이터 세팅
        categoryService.setTestData();
        // 검색을 위한 인덱싱
        categoryService.indexIdx();
        categoryService.indexName();
        categoryService.indexParentIdx();
        // 검색
        // 1. 인덱스로 검색하는 경우
         List<CategoryEntity> searchData = categoryService.getByIdx(1);
        // 2. 이름으로 검색하는 경우
        // List<CategoryEntity> searchData = categoryService.getByName("공지사항");
        // 자식, 부모 정보 추가
        List<CategoryDto> results = categoryService.addDetail(searchData);
        // 출력
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(results);
        System.out.println(json);

        // 문제 2. 코인
        int[] coins = {2, 5, 3, 6};
        int sum = 10;
        int result = dp(coins, sum);
        System.out.println("결과: " + result);
    }

    public static int dp(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[sum];
    }
}