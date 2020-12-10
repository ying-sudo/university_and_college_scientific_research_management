export function getDelIdMap() {
    var deleteId_map = new Map([
        ["loginlog", "loginLogId"], 
        ["operationlog", "operationLogId"], 
        ["systemlog", "managerSystemLogId"], 
     
    ]);

    return deleteId_map;
}