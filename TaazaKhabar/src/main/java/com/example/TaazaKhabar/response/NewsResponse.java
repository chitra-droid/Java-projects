package com.example.TaazaKhabar.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsResponse {
    String status;
    List<ArticleResponse> articles;
}
