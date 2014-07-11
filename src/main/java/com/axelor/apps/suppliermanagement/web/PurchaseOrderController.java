/**
 * Axelor Business Solutions
 *
 * Copyright (C) 2012-2014 Axelor (<http://axelor.com>).
 *
 * This program is free software: you can redistribute it and/or  modify
 * it under the terms of the GNU Affero General Public License, version 3,
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.axelor.apps.suppliermanagement.web;

import com.axelor.apps.suppliermanagement.service.PurchaseOrderSupplierLineService;
import com.axelor.apps.suppliermanagement.service.PurchaseOrderSupplierService;
import com.axelor.apps.purchase.db.PurchaseOrder;
import com.axelor.exception.service.TraceBackService;
import com.axelor.rpc.ActionRequest;
import com.axelor.rpc.ActionResponse;
import com.google.inject.Inject;

public class PurchaseOrderController {

	@Inject
	private PurchaseOrderSupplierService purchaseOrderSupplierService;
	
	@Inject
	private PurchaseOrderSupplierLineService purchaseOrderSupplierLineService;
	
	public void generateSuppliersPurchaseOrder(ActionRequest request, ActionResponse response){
		
		PurchaseOrder purchaseOrder = request.getContext().asType(PurchaseOrder.class);
		
		try {
			purchaseOrderSupplierService.generateSuppliersPurchaseOrder(PurchaseOrder.find(purchaseOrder.getId()));
			response.setFlash("Demande de consultations fournisseurs créées");
			response.setReload(true);
		}
		catch (Exception e) { TraceBackService.trace(response, e); }
	}
	
	
	public void generateSuppliersRequests(ActionRequest request, ActionResponse response){
		
		PurchaseOrder purchaseOrder = request.getContext().asType(PurchaseOrder.class);
		
		try {
			purchaseOrderSupplierService.generateAllSuppliersRequests(PurchaseOrder.find(purchaseOrder.getId()));
			response.setFlash("Génération des devis fournisseurs terminée");
			response.setReload(true);
		}
		catch (Exception e) { TraceBackService.trace(response, e); }
	}
}
