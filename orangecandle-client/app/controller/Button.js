Ext.define('OrangeCandle.controller.Button', {
	extend : 'Ext.app.Controller',
	config : {
		refs : {
			mainView : 'mainmenuview'
		},
		control : {
			'[ref]' : {
				tap : 'onClick'
			}
		}
	},
	onClick : function(button, event, opts) {
		var me = this;
		var ref = button.ref;
		if (ref.flex === undefined)
			ref.flex = 1;
		var loadStores = this.loadStores;
		loadStores(button);
		var mainView = this.getMainView();
		var generateInsertForm = this.generateInsertForm;
		var generateEditForm = this.generateEditForm;
		var loadForm = this.loadForm;
		mainView.push({// there is view in controller! no!
			xtype : 'panel',
			layout : 'vbox',
			listeners : {
				painted : function() {
					loadStores(button);
				}
			},
			items : [ ref, {
				xtype : 'toolbar',
				docked : 'bottom',
				items : [ {
					iconCls : 'add',
					hidden : !button.form,
					flex : 1,
					handler : function() {
						mainView.push(generateInsertForm(button));
					}
				}, {
					iconCls : 'compose',
					hidden : !button.form || button.form.editable === false,
					flex : 1,
					handler : function() {
						var list = this.up('panel').down('list');
						if (list.hasSelection() === false)
							Ext.Msg.alert("Please select a record to edit.");
						else {
							mainView.push(generateEditForm(button));
							var id = list.getSelection()[0].data.id;
							var url = ref.store.toLowerCase() + '/findAll';
							loadForm(button.form.xtype, url, id);
						}
					}
				}, {
					iconCls : 'delete',
					hidden : button.ref.indelible,
					flex : 1,
					handler : function() {
						var list = this.up('panel').down('list');
						if (list.hasSelection() === false)
							Ext.Msg.alert("Please select a record to delete.");
						else {
							var id = list.getSelection()[0].data.id;
							var url = ref.store.toLowerCase() + '/remove';
							me.deleteRecord(id, url, function() {
								loadStores(button);
							});
						}
					}
				} ]
			} ]
		});
	},
	loadStores : function(button) {// todo:ref
		var ref = button.ref
		if (button.ref.store !== undefined) {
			if (button.ref.storeParams) {
				ref.storeParams.username = OrangeCandle.util.Auth.username
			}
			var mainStore = Ext.data.StoreManager.lookup(button.ref.store);
			var extraParams = mainStore.getProxy().getExtraParams();
			for ( var i in button.ref.storeParams) {
				extraParams[i] = button.ref.storeParams[i];
			}
			mainStore.load();
		}
		if (button.ref.extraStore !== undefined) {
			if (button.ref.extraStore instanceof Array) {
				button.ref.extraStore.forEach(function(object) {
					Ext.data.StoreManager.lookup(object).load();
				});
			} else
				Ext.data.StoreManager.lookup(button.ref.extraStore).load();
		}
	},
	deleteRecord : function(id, url, callback) {
		var mainView = this.getMainView();
		Ext.Ajax.request({
			url : OrangeCandle.util.Scalability.getApplicationServer(url),
			params : {
				id : id
			},
			success : function(response) {
				var message = Ext.JSON.decode(response.responseText).message;
				Ext.Msg.alert('', message, Ext.emptyFn);
				if (callback) {
					callback();
				}
			},
			failure : function(response) {
				var message = Ext.JSON.decode(response.responseText).message;
				Ext.Msg.alert('', message, Ext.emptyFn);
			}
		});
	},
	generateInsertForm : function(button) {
		var ref = button.ref;
		var name = ref.alias !== undefined ? ref.alias : ref.store;
		button.form.title = "Insert " + name;
		return button.form;
	},
	generateEditForm : function(button) {
		var ref = button.ref;
		var name = ref.alias !== undefined ? ref.alias : ref.store;
		button.form.title = "Edit " + name;
		return button.form;
	},
	loadForm : function(xtype, url, id) {
		var loadSuccess = function(form, result, data) {
			// it didn't do it automagically, so here we go
			for ( var key in result.data) {
				var value = eval('result.data.' + key);
				var field = form.down('[name=' + key + ']');
				if (!field)
					continue;
				if (field.xtype === 'list') {
					var values = JSON.parse(eval('result.data.' + key));
					var data = field.getStore().getData().all;
					for ( var item in data) {
						for ( var val in values) {
							if (values[val] === data[item].data.id) {
								field.select(item);
								break;
							}
						}
					}
				} else {
					field.setValue(value);
				}
			}
		}
		Ext.ComponentQuery.query(xtype)[0].load({
			url : OrangeCandle.util.Scalability.getApplicationServer(url
					+ '?id=' + id),
			success : function(form, result, data) {
				loadSuccess(form, result, data);
			},
			failure : function() {
				Ext.Msg
						.alert("", "Failed loading data",
								this.getMainView().pop);
			}
		});

	}
});