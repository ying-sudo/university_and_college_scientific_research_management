//返回URL与需要加载的表格json的对应关系
export function getTableMap() {
    var table_map = new Map([
        ["/project", "/project_table/ProjectTable.json"],
        ["/funds", "/funds_table/FundsTable.json"],
    ]);

    return table_map;
}
