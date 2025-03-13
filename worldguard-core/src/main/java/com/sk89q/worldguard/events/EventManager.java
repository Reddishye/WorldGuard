/*
 * WorldGuard, a suite of tools for Minecraft
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldGuard team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldguard.events;

import com.sk89q.worldguard.events.listeners.AddRegionMembersListener;
import com.sk89q.worldguard.events.listeners.AddRegionOwnersListener;
import com.sk89q.worldguard.events.listeners.CreateRegionListener;
import com.sk89q.worldguard.events.listeners.RegionSetPriorityListener;
import com.sk89q.worldguard.events.listeners.RemoveRegionListener;
import com.sk89q.worldguard.events.listeners.RemoveRegionMembersListener;
import com.sk89q.worldguard.events.listeners.RemoveRegionOwnersListener;
import com.sk89q.worldguard.events.listeners.SetFlagRegionListener;

import java.util.ArrayList;

/**
 * Manages internal WorldGuard events and dispatches them to registered listeners.
 */
public class EventManager {

    private final ArrayList<CreateRegionListener> createRegionEventListeners = new ArrayList<>();
    private final ArrayList<RemoveRegionListener> removeRegionListeners = new ArrayList<>();
    private final ArrayList<SetFlagRegionListener> setFlagRegionListeners = new ArrayList<>();
    private final ArrayList<AddRegionOwnersListener> addRegionOwnerListeners = new ArrayList<>();
    private final ArrayList<AddRegionMembersListener> addRegionMembersListeners = new ArrayList<>();
    private final ArrayList<RemoveRegionOwnersListener> removeRegionOwnersListeners = new ArrayList<>();
    private final ArrayList<RemoveRegionMembersListener> removeRegionMembersListeners = new ArrayList<>();
    private final ArrayList<RegionSetPriorityListener> regionSetPriorityListeners = new ArrayList<>();

    /**
     * Registers a listener for region creation events.
     *
     * @param listener the listener to register
     */
    public void registerListener(CreateRegionListener listener) {
        createRegionEventListeners.add(listener);
    }

    /**
     * Registers a listener for region removal events.
     *
     * @param listener the listener to register
     */
    public void registerListener(RemoveRegionListener listener) {
        removeRegionListeners.add(listener);
    }

    /**
     * Registers a listener for region flag setting events.
     *
     * @param listener the listener to register
     */
    public void registerListener(SetFlagRegionListener listener) {
        setFlagRegionListeners.add(listener);
    }

    /**
     * Registers a listener for adding owners to a region.
     *
     * @param listener the listener to register
     */
    public void registerListener(AddRegionOwnersListener listener) {
        addRegionOwnerListeners.add(listener);
    }

    /**
     * Registers a listener for adding members to a region.
     *
     * @param listener the listener to register
     */
    public void registerListener(AddRegionMembersListener listener) {
        addRegionMembersListeners.add(listener);
    }

    /**
     * Registers a listener for removing owners from a region.
     *
     * @param listener the listener to register
     */
    public void registerListener(RemoveRegionOwnersListener listener) {
        removeRegionOwnersListeners.add(listener);
    }

    /**
     * Registers a listener for removing members from a region.
     *
     * @param listener the listener to register
     */
    public void registerListener(RemoveRegionMembersListener listener) {
        removeRegionMembersListeners.add(listener);
    }

    /**
     * Registers a listener for setting region priorities.
     *
     * @param listener the listener to register
     */
    public void registerListener(RegionSetPriorityListener listener) {
        regionSetPriorityListeners.add(listener);
    }

    /**
     * Dispatches a region creation event to all registered listeners.
     *
     * @param e the event to call
     */
    public void call(NewRegionEvent e) {
        for (CreateRegionListener listener : createRegionEventListeners) {
            listener.accept(e);
        }
    }

    /**
     * Dispatches a region priority setting event to all registered listeners.
     *
     * @param e the event to call
     */
    public void call(RegionSetPriorityEvent e) {
        for (RegionSetPriorityListener listener : regionSetPriorityListeners) {
            listener.accept(e);
        }
    }

    /**
     * Dispatches a region flag setting event to all registered listeners.
     *
     * @param e the event to call
     */
    public void call(SetFlagRegionEvent e) {
        for (SetFlagRegionListener listener : setFlagRegionListeners) {
            listener.accept(e);
        }
    }

    /**
     * Dispatches a region removal event to all registered listeners.
     *
     * @param e the event to call
     */
    public void call(RemoveRegionEvent e) {
        for (RemoveRegionListener listener : removeRegionListeners) {
            listener.accept(e);
        }
    }

    /**
     * Dispatches an event for adding members to a region to all registered listeners.
     *
     * @param e the event to call
     */
    public void call(AddRegionMembersEvent e) {
        for (AddRegionMembersListener listener : addRegionMembersListeners) {
            listener.accept(e);
        }
    }

    /**
     * Dispatches an event for removing members from a region to all registered listeners.
     *
     * @param e the event to call
     */
    public void call(RemoveRegionMembersEvent e) {
        for (RemoveRegionMembersListener listener : removeRegionMembersListeners) {
            listener.accept(e);
        }
    }

    /**
     * Dispatches an event for adding owners to a region to all registered listeners.
     *
     * @param e the event to call
     */
    public void call(AddRegionOwnersEvent e) {
        for (AddRegionOwnersListener listener : addRegionOwnerListeners) {
            listener.accept(e);
        }
    }

    /**
     * Dispatches an event for removing owners from a region to all registered listeners.
     *
     * @param e the event to call
     */
    public void call(RemoveRegionOwnersEvent e) {
        for (RemoveRegionOwnersListener listener : removeRegionOwnersListeners) {
            listener.accept(e);
        }
    }

}
