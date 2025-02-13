/*
 *  Copyright (C) <2022> <XiaoMoMi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.momirealms.customcrops.integrations.protection;

import net.crashcraft.crashclaim.api.CrashClaimAPI;
import net.crashcraft.crashclaim.permissions.PermissionRoute;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CrashClaim implements Integration{

    @Override
    public boolean canBreak(Location location, Player player) {
        CrashClaimAPI crashClaimAPI = net.crashcraft.crashclaim.CrashClaim.getPlugin().getApi();
        return crashClaimAPI.getPermissionHelper().hasPermission(player.getUniqueId(), location, PermissionRoute.BUILD);
    }

    @Override
    public boolean canPlace(Location location, Player player) {
        CrashClaimAPI crashClaimAPI = net.crashcraft.crashclaim.CrashClaim.getPlugin().getApi();
        return crashClaimAPI.getPermissionHelper().hasPermission(player.getUniqueId(), location, PermissionRoute.BUILD);
    }
}
