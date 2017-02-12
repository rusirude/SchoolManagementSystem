/**
 * @Author : Rusiru De Silva
 */

function getDataTableRequset(inputObj){
    var requestObj = {
                        draw:0,
                        start:0,
                        length:0,
                        sortColumnName:"",
                        sortOrder:""
                     }
    requestObj.draw = inputObj.draw;
    requestObj.start =  inputObj.start;
    requestObj.length =  inputObj.length;
    requestObj.sortColumnName = inputObj.columns[inputObj.order[0].column].name;
    requestObj.sortOrder = inputObj.order[0].dir;

    return requestObj;
}