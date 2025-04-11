package com.civa.spring.app.dto;

import java.util.List;

public class PaginatedResponse<T> {

    private List<T> data;
    private Meta meta;

    public PaginatedResponse(List<T> data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public static class Meta {
        private int page;
        private int take;
        private int skip;
        private long totalItems;
        private int totalPages;

        public Meta(int page, int take, int skip, long totalItems, int totalPages) {
            this.page = page;
            this.take = take;
            this.skip = skip;
            this.totalItems = totalItems;
            this.totalPages = totalPages;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getTake() {
            return take;
        }

        public void setTake(int take) {
            this.take = take;
        }

        public int getSkip() {
            return skip;
        }

        public void setSkip(int skip) {
            this.skip = skip;
        }

        public long getTotalItems() {
            return totalItems;
        }

        public void setTotalItems(long totalItems) {
            this.totalItems = totalItems;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }
    }
}
