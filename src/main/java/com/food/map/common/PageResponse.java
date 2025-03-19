package com.food.map.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.function.Function;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.domain.Page;

@Schema(description = "페이지 응답 모델")
@Jacksonized
@Getter
@Builder(toBuilder = true)
public class PageResponse<R> {

    @Schema(description = "페이지 사이즈")
    private final int pageSize;

    @Schema(description = "현재 페이지번호")
    private final int pageNumber;

    @Schema(description = "전체 Row 수")
    private final long totalElements;

    @Schema(description = "전체 페이지수")
    private final int totalPages;

    @ArraySchema(arraySchema = @Schema(title = "페이지내 컨텐츠"))
    private final List<R> content;

    @JsonIgnore
    public static PageResponse<Object> empty() {
        return PageResponse.builder().content(List.of()).totalElements(0L).build();
    }

    @JsonIgnore
    public static <T, R> PageResponse<R> of(Page<T> page, Function<T, R> function) {
        var content = page.getContent().stream().map(function).toList();

        return PageResponse.<R>builder()
            .content(content)
            .totalElements(page.getTotalElements())
            .totalPages(page.getTotalPages())
            .pageNumber(page.getNumber())
            .pageSize(page.getSize())
            .build();
    }

    @JsonIgnore
    public static <T, R> PageResponse<R> of(Page<T> page, List<R> content) {
        return PageResponse.<R>builder()
            .content(content)
            .totalElements(page.getTotalElements())
            .totalPages(page.getTotalPages())
            .pageNumber(page.getNumber())
            .pageSize(page.getSize())
            .build();
    }

    @Override
    public String toString() {
        return "PageResponse{" +
               "pageSize=" + pageSize +
               ", pageNumber=" + pageNumber +
               ", totalElements=" + totalElements +
               ", totalPages=" + totalPages +
               ", " + content +
               '}';
    }
}
