/**
 * [Code] author by $YourName$
 * @include "../../extclient/RowExpander.js"
 * @include "../../extclient/gridToExcel.js"
 * @include "../../extclient/SearchField.js"
 */
 
Ext.namespace('com.slk.core');
Ext.namespace('com.slk.core.code');

/**
 * 查询表单
 * @class com.slk.core.code.queryformpanel
 * @extends Ext.form.FormPanel
 */
com.slk.core.code.queryformpanel = Ext.extend(Ext.form.FormPanel,{
	initComponent:function() {
		Ext.apply(this,{
	        labelAlign:'right',
	        labelWidth:80,
	        defaultType:'textfield',
	        bodyStyle:'padding:20px;',
	        defaults:{width:290},
	        items:[{
	            xtype:'panel',
	            html:'请在下面输入查询条件：',
	            width:370,
	            border:false,
	            style:'padding:10 0 0 3;margin:0 0 20 10;border-bottom:1px solid #ccc;font-size:14px;font-weight:bold;'
	        	}
	        	,{
	            xtype:'panel',
	            layout:'column',
	            width:400,
	            border:false,
	            defaults:{border:false}
	        	}
	        	,{xtype:'textfield',fieldLabel:'类型码',name:'s_type',width:288}
	        	,{xtype:'textfield',fieldLabel:'编码',name:'s_code',width:288}
	        	,{xtype:'textfield',fieldLabel:'字典码',name:'s_dictionaryCode',width:288}
	        	,{xtype:'textfield',fieldLabel:'字典值',name:'s_dictionaryValue',width:288}
	        	,{xtype:'textfield',fieldLabel:'备用值',name:'s_reserveValue',width:288}
	        	,{xtype:'textfield',fieldLabel:'备注',name:'s_comment',width:288}
	        	,{xtype:'textfield',fieldLabel:'created',name:'s_created',width:288}
	        	,{xtype:'textfield',fieldLabel:'deleted',name:'s_deleted',width:288}
	        	,{xtype:'textfield',fieldLabel:'lastOperateTime',name:'s_lastOperateTime',width:288}
	            ]
	    });
		com.slk.core.code.queryformpanel.superclass.initComponent.call(this);
	}
});

/**
 * 查询窗口
 * @class com.slk.core.code.querywin
 * @extends Ext.Window
 */
com.slk.core.code.querywin = Ext.extend(Ext.Window,{
	initComponent:function() {
		Ext.apply(this,{
	        title:'高级查询',
	        width:455,
	        height:395,
	        modal:true,
	        closeAction:'hide',
	        layout:'fit'
	    });
		com.slk.core.code.querywin.superclass.initComponent.call(this);
	}
});

/**
 * 内容表单
 * @class com.slk.core.code.dtlformpanel
 * @extends Ext.form.FormPanel
 */
com.slk.core.code.dtlformpanel = Ext.extend(Ext.form.FormPanel,{
	initComponent:function() {
		Ext.apply(this,{
	        labelWidth:100,
	        labelAlign:'right',
	        frame:true,
//	        bodyStyle:'padding:10px',
	        autoScroll:true,//滚动条
			items:[{
		            xtype:'panel',
		            layout:'column',
		            width:400,
		            border:false,
		            defaults:{border:false}
		        	}
	        		,{xtype:'hidden',fieldLabel:'id',name:'id',width:288}
	        		,{xtype:'textfield',fieldLabel:'类型码',name:'type',width:288}
	        		,{xtype:'textfield',fieldLabel:'编码',name:'code',width:288}
	        		,{xtype:'textfield',fieldLabel:'字典码',name:'dictionaryCode',width:288}
	        		,{xtype:'textfield',fieldLabel:'字典值',name:'dictionaryValue',width:288}
	        		,{xtype:'textfield',fieldLabel:'备用值',name:'reserveValue',width:288}
	        		,{xtype:'textfield',fieldLabel:'备注',name:'comment',width:288}
	        		,{xtype:'textfield',fieldLabel:'created',name:'created',width:288}
	        		,{xtype:'textfield',fieldLabel:'deleted',name:'deleted',width:288}
	        		,{xtype:'textfield',fieldLabel:'lastOperateTime',name:'lastOperateTime',width:288}
	        ]
	    });
	    com.slk.core.code.dtlformpanel .superclass.initComponent.call(this);
	}
	
});

/**
 * 表单窗口
 * @class com.slk.core.code.dtlwin
 * @extends Ext.Window
 */		
com.slk.core.code.dtlwin =  Ext.extend(Ext.Window,{
	initComponent:function() {
		Ext.apply(this,{
	        width:535,
	        height:400,
	        layout:'fit',
	        border:false,
	        closeAction:'hide',
	        modal:true,
	        maximizable:true,
	        constrain: true,
	        collapsible:true
	    });
		com.slk.core.code.dtlwin.superclass.initComponent.call(this);
	}
});


/**
 * 主表格入口
 * @class com.slk.core.code
 * @extends Ext.grid.GridPanel
 */
com.slk.core.codeGrid = Ext.extend(Ext.grid.GridPanel,{
    initComponent:function() {
    	this.pageSize=10;
    	this.ds = new Ext.data.Store({
	        url:'../Code/extlist.do',
	        reader:new Ext.data.JsonReader({
	            root:'list',
	            totalProperty:'totalSize',
	            id:'id'
		        }
		        ,['id','type','code','dictionaryCode','dictionaryValue','reserveValue','comment','created','deleted','lastOperateTime',]
	        ),
	        baseParams:{
	            limit:this.pageSize
	        },
	        remoteSort:true
	    });
	    
	    //行扩展
	    this.expander = new Ext.grid.RowExpander({
	        tpl : new Ext.Template(
	            '<p style="margin-left:70px"><b>字典内容:</b> {kvalue}</p><br>'
	        )
	    });
	    
	    this.sm = new Ext.grid.CheckboxSelectionModel();
		this.cm = new Ext.grid.ColumnModel([
		    new Ext.grid.RowNumberer(),
		    this.sm,
		    this.expander
	        ,{header:'类型码',width:100,sortable:true,dataIndex:'type'}
	        ,{header:'编码',width:100,sortable:true,dataIndex:'code'}
	        ,{header:'字典码',width:100,sortable:true,dataIndex:'dictionaryCode'}
	        ,{header:'字典值',width:100,sortable:true,dataIndex:'dictionaryValue'}
	        ,{header:'备用值',width:100,sortable:true,dataIndex:'reserveValue'}
	        ,{header:'备注',width:100,sortable:true,dataIndex:'comment'}
	        ,{header:'created',width:100,sortable:true,dataIndex:'created'}
	        ,{header:'deleted',width:100,sortable:true,dataIndex:'deleted'}
	        ,{header:'lastOperateTime',width:100,sortable:true,dataIndex:'lastOperateTime'}
		]);
		
		/**
		 * 扩展类的构建开始
		 */
		Ext.apply(this,{
			store:this.ds
	        ,sm:this.sm
	        ,cm: this.cm
			,plugins:this.expander
			,collapsible: true
			,viewConfig:{forceFit:true}
	        ,bbar:new Ext.PagingToolbar({
	            pageSize:this.pageSize,
	            store:this.ds,
	            displayInfo:true
	        })
	        , tbar:[
	        	{text:'新增',cls:'x-btn-text-icon',iconCls:'addicon',handler:this.addCode,scope:this},'-'
	        	,{text:'修改',cls:'x-btn-text-icon',iconCls:'editicon',handler:this.editCode,scope:this},'-'
	        	,{text:'删除',cls:'x-btn-text-icon',iconCls:'deleteicon',handler:this.deleteCode,scope:this},'-'
	        	,{text:'查询',id:'btn-query',cls:'x-btn-text-icon',iconCls:'queryicon',handler:this.buildQueryWin,scope:this}
	        	,'->'
	        	,'搜索范围：'
				,{xtype:'combo',
	            fieldLabel:'搜索范围',
	            emptyText:'请选择...',
	            name:'field_type',
	            hiddenName:'field_type',
	            store:new Ext.data.ArrayStore({
        			fields: ['name','code'],
        			data: [['类型码', 'type'],['编码', 'code'],['字典码', 'dictionaryCode'],['字典值', 'dictionaryValue'],['备用值', 'reserveValue'],['备注', 'comment'],['created', 'created'],['deleted', 'deleted'],['lastOperateTime', 'lastOperateTime']]
        		}),
	            displayField:'name',
	            valueField:'code',
	            forceSelection: false,
	            selectOnFocus: true,
	            editable: false,
	            triggerAction: 'all',
	            allowBlank:true,
	            mode: 'local',
	            width:120
	            ,listeners: {          
          			select:{fn:function(object,record,index){
          				this.getTopToolbar().items.get("searchfld").getStore().baseParams['field_type'] = object.getValue();
          			},scope:this}
          		}    
	        	},{xtype:"searchfield",itemId:"searchfld",width: 130,store:this.ds}
	        ]
		});
		//调用父类构建函数
        com.slk.core.codeGrid.superclass.initComponent.call(this);
        //加载数据
        this.store.load({params:{start:0}});
        
 		//扩展类的详细弹出窗口
 		this.dtlformpanel = new com.slk.core.code.dtlformpanel();
 		this.dtlwin =  new com.slk.core.code.dtlwin({items:this.dtlformpanel,buttons:[{
	            text:'保存',
	            handler:this.saveCode,
	            scope:this
	        },{
	            text:'取消',
	            handler:function(){this.dtlwin.hide();},
	            scope:this
	        }]});
	    
	    //扩展类的查询弹出窗口
	    this.queryformpanel = new com.slk.core.code.queryformpanel();
	    this.querywin =  new com.slk.core.code.querywin({items:this.queryformpanel,buttons:[{
	            text:'确定',
	            handler:this.queryOrder,
	            scope:this
	        },{
	            text:'取消',
	            handler:function(){this.querywin.hide();},
	            scope:this
	        }]});
	    //双击操作
 		this.on({"dblclick":this.dblclick});
 		//右键菜单监听
 		this.addListener('rowcontextmenu', this.onMessageContextMenu);
    }
    
   /**
    * 构建函数结束
    */

	//右键菜单
    ,onMessageContextMenu : function (grid, rowIndex, e) {
		e.stopEvent();
		var coords = e.getXY();
		var record = grid.getStore().getAt(rowIndex);
		var messageContextMenu = new Ext.menu.Menu({
			id: 'messageContextMenu',
			items: [{icon:'../../images/edit.gif',text: '编辑',handler: rgtEdit,scope: this},
	        		{id: 'delete',icon:'../../images/delete.gif',handler: rgtDelete,text: '删除'
	        }]
	    });
	    //右键编辑
	    function rgtEdit() {
	            		messageContextMenu.hide();
				        this.dtlwin.setTitle('修改Code');
				        this.dtlwin.show();
				        this.dtlformpanel.form.reset();
				        this.dtlformpanel.form.loadRecord(record);
				        this.dtlformpanel.url = '../Code/extupdate.do';
	    };
	    //右键删除
		function rgtDelete() {
			messageContextMenu.hide();
			if (!record||record.length == 0) {
				Ext.Msg.alert("提示", "请先选择要删除的�记录");
				return;
			}
			Ext.MessageBox.confirm('确认删除','确定要删除这些记录?',function(btn){
				if (btn == 'yes'){
						Ext.Ajax.request({
						url:'../Code/extdelete.do?ids='+record.data.id,
						method:'POST',
						success:function(response){
							var data = Ext.util.JSON.decode(response.responseText);
							if (data.success == true){
								grid.getStore().remove(record);
								grid.getView().refresh();
							}
							else{
								Ext.MessageBox.alert('警告',data.msg);
							}
							 grid.getStore().reload();
						},
						scope:this
					});
				}},this);
		};
		messageContextMenu.showAt([coords[0], coords[1]]);
		e.preventDefault();//to disable the standard browser context menu
	}
	
	//双击事件
    ,dblclick :function(){
	    	var sm = this.getSelectionModel();
	   		var record=null;
			try{
				record=sm.getSelected();
				if(record==null){
					return;
				}
			}
			catch(e){
				try{
					record=sm.selection.record();
				}
				catch(ex){}
			}
	    	this.showWinForm(record);
	}
	//双击打开窗口
    ,showWinForm:function(record){
        this.dtlwin.setTitle('修改Code');
        this.dtlwin.show();
        this.dtlformpanel.form.reset();
        this.dtlformpanel.form.loadRecord(record);
        this.dtlformpanel.url = '../Code/extupdate.do';
    }
    
    //新建窗口
    ,addCode : function(){
        this.dtlwin.setTitle('新建Code');
        this.dtlwin.show();
        this.dtlformpanel.form.reset();
	    this.dtlformpanel.url = '../Code/extsave.do';
	}
	
	//编辑操作
    ,editCode:function(){
    	var records = this.getSelectionModel().getSelections();//单选
    	
	   if (records.length!=1) {
			Ext.Msg.alert("提示", "请先选择要修改的记录");
			return;
		}
	    this.dtlwin.setTitle('修改Code');
	    this.dtlwin.show();
	    this.dtlformpanel.form.reset();
	    this.dtlformpanel.form.loadRecord(records[0]);
	    this.dtlformpanel.url = '../Code/extupdate.do';

    }
    
    //删除操作
    ,deleteCode:function(){
    	var records = this.getSelectionModel().getSelections();
		if (!records||records.length == 0) {
			Ext.Msg.alert("提示", "请先选择要删除的�记录");
			return;
		}
		Ext.MessageBox.confirm('确认删除','确定要删除这些记录?',function(btn){
			if (btn == 'yes'){
				Ext.Ajax.request({
					url:'../Code/extdelete.do?ids='+this.getRecordArrayUtils(records, 'id'),
		            method:'POST',
		            success:function(response){
		                var data = Ext.util.JSON.decode(response.responseText);
		                if (data.success == true){
			                for(var i = 0; i < records.length; i++) {
							 	this.getStore().remove(records[i]);
			                    this.getView().refresh();
							 }
							 this.getStore().reload();
		                }
		                else{
		                    Ext.MessageBox.alert('警告',data.msg);
		                }
		            },
		            scope:this
		        });
			}
		},this);
    }
    
    //保存操作
    ,saveCode:function(){
		if (this.dtlformpanel.form.isValid() == false){
	        return;
	    }
	    this.dtlformpanel.form.submit({
	        url:this.dtlformpanel.url,
	        success:function(form,action){
	        	Ext.MessageBox.alert('警告',action.result.msg);
	            this.dtlwin.hide();
	          	this.getStore().reload();
	        },
	        scope:this,
	        failure:function(form,action){
	            Ext.MessageBox.alert('警告',action.result.msg);
	        }
	    })
	
    }
    //新建查询窗口
    ,buildQueryWin: function(){
    	this.querywin.setTitle('查询');
        this.querywin.show();
        this.getTopToolbar().items.get("searchfld").setValue("");
        this.getTopToolbar().items.get("searchfld").getStore().baseParams['field_type']=null;
    }
    //查询操作
    ,queryOrder:function(){
    	this.getStore().baseParams['s_type'] = this.queryformpanel.form.findField('s_type').getRawValue();
    	this.getStore().baseParams['s_code'] = this.queryformpanel.form.findField('s_code').getRawValue();
    	this.getStore().baseParams['s_dictionaryCode'] = this.queryformpanel.form.findField('s_dictionaryCode').getRawValue();
    	this.getStore().baseParams['s_dictionaryValue'] = this.queryformpanel.form.findField('s_dictionaryValue').getRawValue();
    	this.getStore().baseParams['s_reserveValue'] = this.queryformpanel.form.findField('s_reserveValue').getRawValue();
    	this.getStore().baseParams['s_comment'] = this.queryformpanel.form.findField('s_comment').getRawValue();
    	this.getStore().baseParams['s_created'] = this.queryformpanel.form.findField('s_created').getRawValue();
    	this.getStore().baseParams['s_deleted'] = this.queryformpanel.form.findField('s_deleted').getRawValue();
    	this.getStore().baseParams['s_lastOperateTime'] = this.queryformpanel.form.findField('s_lastOperateTime').getRawValue();
		this.getStore().load();
		this.querywin.hide();
    }
    //工具类
    ,getRecordArrayUtils : function(records,field) {
		var result = [];
		for(var i = 0; i < records.length; i++) {
			result.push(records[i].get(field));
		}
		return result;
	}

});
 
/**
 * 注册主表格的xtype
 */
Ext.reg('code', com.slk.core.codeGrid);


