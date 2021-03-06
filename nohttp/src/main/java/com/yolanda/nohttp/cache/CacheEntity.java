/*
 * Copyright © Yan Zhenjie. All Rights Reserved
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yolanda.nohttp.cache;

import com.yolanda.nohttp.Headers;
import com.yolanda.nohttp.HttpHeaders;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.db.DBId;
import com.yolanda.nohttp.db.Field;

import org.json.JSONException;

import java.io.Serializable;

/**
 * <p>Cache entity class.</p>
 * Created in Jan 10, 2016 12:43:10 AM.
 *
 * @author Yan Zhenjie;
 */
public class CacheEntity implements DBId, Field, Serializable {

    private static final long serialVersionUID = 12348534793L;

    private long id;

    /**
     * The cache key.
     */
    private String key;
    /**
     * The server response headers.
     */
    private Headers responseHeaders = new HttpHeaders();

    /**
     * Cache data.
     */
    private byte[] data = {};

    /**
     * Cached in the local expiration time.
     */
    private long localExpire;

    public CacheEntity() {
    }

    /**
     * @param id              id.
     * @param key             key.
     * @param responseHeaders http response headers.
     * @param data            http response data.
     * @param localExpire     local expire time.
     */
    public CacheEntity(long id, String key, Headers responseHeaders, byte[] data, long localExpire) {
        this.id = id;
        this.key = key;
        this.responseHeaders = responseHeaders;
        this.data = data;
        this.localExpire = localExpire;
    }

    /**
     * @return the id.
     */
    @Override
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the key.
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set.
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the responseHeaders.
     */
    public Headers getResponseHeaders() {
        return responseHeaders;
    }

    /**
     * @param responseHeaders the responseHeaders to set.
     */
    public void setResponseHeaders(Headers responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    /**
     * Set the {@link Headers#setJSONString(String)} can Parse the json data, format conforms to the corresponding Http header format.
     *
     * @param jsonString conform to the relevant head of the Json data format.
     */
    public void setResponseHeadersJson(String jsonString) {
        try {
            this.responseHeaders.setJSONString(jsonString);
        } catch (JSONException e) {
            Logger.e(e);
        }
    }

    /**
     * To get the json data format of the head.
     *
     * @return json.
     */
    public String getResponseHeadersJson() {
        return this.responseHeaders.toJSONString();
    }

    /**
     * @return the data.
     */
    public byte[] getData() {
        return data;
    }

    /**
     * @param data the data to set.
     */
    public void setData(byte[] data) {
        this.data = data;
    }

    /**
     * @return the localExpire.
     */
    public long getLocalExpire() {
        return localExpire;
    }

    /**
     * @param localExpire the localExpire to set.
     */
    public void setLocalExpire(long localExpire) {
        this.localExpire = localExpire;
    }

}
