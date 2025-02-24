package com.shuzijun.leetcode.plugin.timer;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.StatusBarWidget;
import com.intellij.openapi.wm.StatusBarWidgetFactory;
import com.shuzijun.leetcode.plugin.model.PluginConstant;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;


/**
 * @author shuzijun
 */
public class TimerStatusBarWidgetProvider implements StatusBarWidgetFactory {

    private TimerBarWidget timerBarWidget;

    @Override
    public @NonNls @NotNull String getId() {
        return PluginConstant.LEETCODE_EDITOR_TIMER_STATUS_BAR_ID;
    }

    @Override
    public @Nls @NotNull String getDisplayName() {
        return PluginConstant.LEETCODE_EDITOR_TIMER_STATUS_BAR_ID;
    }

    @Override
    public boolean isAvailable(@NotNull Project project) {
        return true;
    }

    @Override
    public @NotNull StatusBarWidget createWidget(@NotNull Project project) {
        if (timerBarWidget == null) {
            timerBarWidget = new TimerBarWidget(project);
        }
        return timerBarWidget;
    }

    @Override
    public void disposeWidget(@NotNull StatusBarWidget widget) {
        if (timerBarWidget != null) {
            Disposer.dispose(timerBarWidget);
        }
    }

    @Override
    public boolean canBeEnabledOn(@NotNull StatusBar statusBar) {
        return false;
    }
}
