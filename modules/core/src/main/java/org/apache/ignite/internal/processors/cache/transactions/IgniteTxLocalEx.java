/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.cache.transactions;

import java.util.Collection;
import javax.cache.expiry.ExpiryPolicy;
import org.apache.ignite.IgniteCheckedException;
import org.apache.ignite.internal.IgniteInternalFuture;
import org.apache.ignite.internal.processors.affinity.AffinityTopologyVersion;
import org.apache.ignite.internal.processors.cache.GridCacheContext;
import org.apache.ignite.internal.processors.cache.KeyCacheObject;
import org.apache.ignite.internal.processors.cache.version.GridCacheVersion;
import org.apache.ignite.internal.util.lang.GridInClosure3;
import org.jetbrains.annotations.Nullable;

/**
 * Local transaction API.
 */
public interface IgniteTxLocalEx extends IgniteInternalTx {
    /**
     * @return Minimum version involved in transaction.
     */
    public GridCacheVersion minVersion();

    /**
     * @return Commit error.
     */
    @Nullable public Throwable commitError();

    /**
     * @throws IgniteCheckedException If commit failed.
     */
    public void userCommit() throws IgniteCheckedException;

    /**
     * @throws IgniteCheckedException If rollback failed.
     */
    public void userRollback() throws IgniteCheckedException;

    /**
     * Finishes transaction (either commit or rollback).
     *
     * @param commit {@code True} if commit, {@code false} if rollback.
     * @return {@code True} if state has been changed.
     * @throws IgniteCheckedException If finish failed.
     */
    public boolean finish(boolean commit) throws IgniteCheckedException;
}
