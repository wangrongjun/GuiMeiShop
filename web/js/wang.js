/**
 *  by wangrongjun on 2017/7/6.
 */

/**
 * @param updateMap 需要更新的参数列表。格式样例：var map={key1:"value1", key2:"value2"};
 * @return newUrl 参数更新后的url
 */
function updateParamInUrl(oldUrl, updateMap) {
    for (var key in updateMap) {
        var value = updateMap[key];
        if (oldUrl.indexOf(key) != -1) {//如果key存在
            oldUrl = oldUrl.replace(/key=[\d]+/, key + "=" + value);
        } else if (oldUrl.indexOf("?") != -1) {//如果?存在，即有别的参数，添加到参数后面
            oldUrl = oldUrl + "&" + key + "=" + value;
        } else {//如果没有参数，直接加在后面
            oldUrl += "?" + key + "=" + value;
        }
    }
    return oldUrl;
}