Ext.define('OrangeCandle.store.Role', {
	extend : 'Ext.data.Store',
	config : {
//		model : 'OrangeCandle.model.Role',
		proxy : {
			type : 'ajax',
			url : "http://localhost:8080/group/getRoles",
			reader : {
				type : "json",
				rootProperty: "data"
			}
		},
		autoLoad : true
	}
});