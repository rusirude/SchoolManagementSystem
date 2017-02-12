/**
 * @Author : Rusiru De Silva
 */


var mainDataTable;

$(document).ready(function(){
    mainDataTable();
});


function mainDataTable(){
    mainDataTable = $('#userRole').DataTable( {
                        ajax: {
                                url : "loadUserRoleForGrid.json",
                                contentType:"application/json",
                                type:"POST",
                                data:function(d){
                                        return JSON.stringify(getDataTableRequset(d));
                                    }
                                },
                        processing: true,
                        serverSide: true,
                        columns: [
                            { data: "id",               name:"id" },
                            { data: "name",             name:"name"},
                            { data: "description",      name:"description"},
                            { data: "addedBy",          name:"addedBy" },
                            { data: "addedOn",          name:"addedOn" },
                            { data: "updatedBy",        name:"updatedBy" },
                            { data: "updatedOn",        name:"updatedOn" }
                        ]
                    } );
}