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
					hidden : !button.form,
					flex : 1,
					handler : function() {
						var list = this.up('panel').down('list');
						if (list.hasSelection() === false)
							Ext.Msg.alert("Please select a record to edit.");
						else {
							mainView.push(generateEditForm(button));
							var id = list.getSelection()[0].data.oid;
							var url = ref.store.toLowerCase() + '/findAll';
							loadForm(button.form.xtype, url, id);
						}
					}
				}, {
					iconCls : 'delete',
					hidden : button.ref.indelible,
					flex : 1
				} ]
			} ]
		});
	},
	loadStores : function(button) {// todo:ref
		if (button.ref.store !== undefined)
			Ext.data.StoreManager.lookup(button.ref.store).load();
		if (button.ref.extraStore !== undefined) {
			if (button.ref.extraStore instanceof Array) {
				button.ref.store.forEach(function(object) {
					Ext.data.StoreManager.lookup(object).load();
				});
			} else
				Ext.data.StoreManager.lookup(button.ref.extraStore).load();
		}
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
		Ext.ComponentQuery.query(xtype)[0].load({
			url : OrangeCandle.util.Scalability.getApplicationServer(url
					+ '?id=' + id),
			success : function(form, result, data) {
				// it didn't do it automagically, so here we go
				for ( var key in result.data) {
					var value = eval('result.data.' + key);
					form.down('[name=' + key + ']').setValue(value);
				}
			},
			failure : function() {
				Ext.Msg
						.alert("", "Failed loading data",
								this.getMainView().pop);
			}
		});
	}
});