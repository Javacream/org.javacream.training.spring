package org.javacream.store.api;

import java.util.List;

public interface StoreService {
    public Integer getStock(String category, String itemId);
    public void setStock(String category, String itemId, Integer stock);
    public List<String> getItemIdsForCategory(String category);
}
