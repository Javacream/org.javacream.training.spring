package org.javacream.store.decorators;

import javax.annotation.Resource;

import org.javacream.audit.api.AuditService;
import org.javacream.store.api.StoreServiceAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Primary
public class AuditingStoreServiceAdmin implements StoreServiceAdmin {

	@Resource(name = "storeServiceAdmin")
	private StoreServiceAdmin delegate;
	
	@Autowired
	private  AuditService auditService;

	public int getStock(String category, String item) {
		auditService.writeAudit("Auditing StoreServiceAdmin, called getStock: category=" + category + ", item=" + item);
		return delegate.getStock(category, item);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void setStock(String category, String item, int stock) {
		auditService.writeAudit("Auditing StoreServiceAdmin, called setStock: category=" + category + ", item=" + item
				+ ", stock=" + stock);
		delegate.setStock(category, item, stock);
		
	}

}
