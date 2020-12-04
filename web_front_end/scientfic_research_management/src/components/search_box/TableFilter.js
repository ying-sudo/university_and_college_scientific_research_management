export function getfilterMap() {
    var filter_map = new Map([
        ["projectlists", [
            {
                value: "id",
                label: "项目编号",
            }, {
                value: "name",
                label: "项目名称",
            },
        ]], ["fundlists", [
            {
                value: "id",
                label: "经费编号",
            }, {
                value: "name",
                label: "经费名称",
            },
        ]],
    ]);

    return filter_map;
}