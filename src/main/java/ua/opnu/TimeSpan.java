package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes;

    // --- Конструктори ---
    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    public TimeSpan(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Хвилини не можуть бути від'ємними");
        }
        this.hours = minutes / 60;
        this.minutes = minutes % 60;
    }

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некоректні параметри часу");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public TimeSpan(TimeSpan span) {
        if (span == null) {
            throw new IllegalArgumentException("TimeSpan не може бути null");
        }
        this.hours = span.getHours();
        this.minutes = span.getMinutes();
    }

    // --- Гетери ---
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // --- Методи додавання (add) ---
    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некоректні параметри часу");
        }
        int totalMin = this.minutes + minutes;
        this.hours += hours + (totalMin / 60);
        this.minutes = totalMin % 60;
    }

    public void add(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Хвилини не можуть бути від'ємними");
        }
        int totalMin = this.minutes + minutes;
        this.hours += totalMin / 60;
        this.minutes = totalMin % 60;
    }

    public void add(TimeSpan span) {
        if (span != null) {
            add(span.getHours(), span.getMinutes());
        }
    }

    // --- Методи віднімання (subtract) ---
    public void subtract(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes > 59) {
            throw new IllegalArgumentException("Некоректні параметри часу");
        }
        int currentTotal = getTotalMinutes();
        int subtractTotal = hours * 60 + minutes;

        if (subtractTotal <= currentTotal) {
            int resultTotal = currentTotal - subtractTotal;
            this.hours = resultTotal / 60;
            this.minutes = resultTotal % 60;
        }
    }

    public void subtract(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Хвилини не можуть бути від'ємними");
        }
        subtract(minutes / 60, minutes % 60);
    }

    public void subtract(TimeSpan span) {
        if (span != null) {
            subtract(span.getHours(), span.getMinutes());
        }
    }

    // --- Загальна тривалість ---
    public double getTotalHours() {
        return hours + (minutes / 60.0);
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    // --- Масштабування ---
    public void scale(int factor) {
        if (factor <= 0) {
            throw new IllegalArgumentException("Factor повинен бути більшим за 0");
        }
        int totalMin = getTotalMinutes() * factor;
        this.hours = totalMin / 60;
        this.minutes = totalMin % 60;
    }
}