Ext
		.define(
				'OrangeCandle.controller.Button',
				{
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
						if (button.ref.flex === undefined)
							button.ref.flex = 1;
						if (button.ref.store !== undefined)
							Ext.data.StoreManager.lookup(button.ref.store)
									.load();
						if (button.ref.extraStore !== undefined) {
							if (button.ref.extraStore instanceof Array) {
								button.ref.store
										.forEach(function(object) {
											Ext.data.StoreManager
													.lookup(object).load();
										});
							} else
								Ext.data.StoreManager.lookup(
										button.ref.extraStore).load();
						}
						var mainView = this.getMainView();
						mainView
								.push({
									xtype : 'panel',
									layout : 'vbox',
									items : [
											button.ref,
											{
												xtype : 'toolbar',
												docked : 'bottom',
												items : [
														{
															iconCls : 'add',
															hidden : !button.form,
															flex : 1,
															handler : function() {
																var ref = button.ref;
																var name = ref.alias !== undefined ? ref.alias
																		: ref.store;
																button.form.title = "Insert "
																		+ name;
																mainView
																		.push(button.form);
															}
														},
														{
															iconCls : 'compose',
															hidden : !button.form,
															flex : 1
														},
														{
															iconCls : 'delete',
															hidden : button.ref.indelible,
															flex : 1
														} ]
											} ]
								});
					}
				});