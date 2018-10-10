package org.javacream.store.decorators;

import javax.annotation.Resource;

import org.javacream.store.api.StoreServiceAdmin;
import org.javacream.util.audit.api.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class AuditingStoreServiceAdmin implements StoreServiceAdmin{
	@Resource(name="storeServiceAdmin") private StoreServiceAdmin delegate;
	@Autowired protected AuditService auditService;
		
	public int getStock(String category, String item) {
		auditService.log("Auditing StoreServiceAdmin, called getStock: category=" + category + ", item=" + item);
		return delegate.getStock(category, item);
	}


	@Override
	public void setStock(String category, String item, int stock) {
		auditService.log("Auditing StoreServiceAdmin, called setStock: category=" + category + ", item=" + item + ", stock=" + stock);
		delegate.setStock(category, item, stock);
	}

}
