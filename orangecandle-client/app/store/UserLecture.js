Ext.define('OrangeCandle.store.UserLecture', {
	extend : 'Ext.data.Store',
	config : {
		model : 'OrangeCandle.model.Lecture',
		proxy : {
			headers : {
				Authorization : OrangeCandle.util.Auth.get()
			},
			type : 'ajax',
			url : OrangeCandle.util.Scalability
					.getApplicationServer("lecture/findAll"),
			reader : {
				type : "json",
				rootProperty : "data"
			}
		},
		autoLoad : false
	}
});