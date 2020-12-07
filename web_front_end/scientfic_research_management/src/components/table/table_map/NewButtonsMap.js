export function getButtonMap() {
    var button_map = new Map([
        ["projectlists", "ProjectTablebutton"], 
        ["loginlog", "LoginLogTableButton"], 
        ["operationlog", "OperationLogTablebutton"], 
        ["systemlog", "SystemTableButton"], 
        ["papers", "PaperTableButton"],         
        ["works", "WorkTableButton"],         
        ["patents", "PatentTableButton"],         
        ["teams", "TeamTableButton"],         
        
    ]);

    return button_map;
}