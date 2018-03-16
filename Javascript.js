$(document).ready(function() {
    function r(r) {
        v = r,
        $(".formelblock input, .formelblock2 input").removeClass("yellowbg"),
        $("input#" + v).addClass("yellowbg")
    }
    function e() {
        "val_a" != v && $("input#val_a").val(m),
        "val_b" != v && $("input#val_b").val(b.toUpperCase())
    }
    function t(r) {
        return parseFloat(String(r).replace(/\,/g, "."))
    }
    function n(r, e) {
        var t = e ? 1 : -1
          , n = $(".formelblock").find("input#" + r).val();
        val_in = parseFloat(n.replace(/\,/g, ".")),
        val_in = Math.round((val_in + t) * d) / d;
        var o = String(val_in).replace(/\./g, ",");
        $(".formelblock").find("input#" + r).val(o),
        $(".formelblock").trigger("keyup")
    }
    function o() {
        var r = location.protocol + "//" + location.host + location.pathname;
        r = r.replace(/\/$/, "") + "/",
        g = r + "?a=" + m,
        $("#memvaluelink").attr("href", g)
    }
    function i(r) {
        for (var e = r.toString(), t = e.length - 1, n = ""; t >= 0; )
            n = a(e.length - t, Number(e.charAt(t))) + n,
            t--;
        return n
    }
    function a(r, e) {
        if (1 == r) {
            if (0 == e)
                return "";
            if (1 == e)
                return "I";
            if (2 == e)
                return "II";
            if (3 == e)
                return "III";
            if (4 == e)
                return "IV";
            if (5 == e)
                return "V";
            if (6 == e)
                return "VI";
            if (7 == e)
                return "VII";
            if (8 == e)
                return "VIII";
            if (9 == e)
                return "IX"
        }
        if (2 == r) {
            if (0 == e)
                return "";
            if (1 == e)
                return "X";
            if (2 == e)
                return "XX";
            if (3 == e)
                return "XXX";
            if (4 == e)
                return "XL";
            if (5 == e)
                return "L";
            if (6 == e)
                return "LX";
            if (7 == e)
                return "LXX";
            if (8 == e)
                return "LXXX";
            if (9 == e)
                return "XC"
        }
        if (3 == r) {
            if (0 == e)
                return "";
            if (1 == e)
                return "C";
            if (2 == e)
                return "CC";
            if (3 == e)
                return "CCC";
            if (4 == e)
                return "CD";
            if (5 == e)
                return "D";
            if (6 == e)
                return "DC";
            if (7 == e)
                return "DCC";
            if (8 == e)
                return "DCCC";
            if (9 == e)
                return "CM"
        } else if (4 == r) {
            for (var t = "", n = 1; n <= e; n++)
                t += "M";
            return t
        }
    }
    function l(r) {
        return "I" == r ? 1 : "V" == r ? 5 : "X" == r ? 10 : "L" == r ? 50 : "C" == r ? 100 : "D" == r ? 500 : "M" == r ? 1e3 : 0
    }
    function c(r) {
        r = String(r).toUpperCase();
        for (var e = 0; e < r.length; e++)
            if (-1 == C.indexOf(r.charAt(e)))
                return p = "Ungültiges Zeichen: " + r.charAt(e),
                null;
        if (r.length > A)
            return console.log("Maximal " + A + " Zeichenlänge!"),
            null;
        for (var t = 0, n = r.length - 1; n >= 0; ) {
            if (l(r.charAt(n)) < l(r.charAt(n + 1))) {
                if (n + 2 <= r.length - 1 && r.charAt(n + 1) == r.charAt(n + 2))
                    return;
                if (n + 3 <= r.length - 1 && r.charAt(n + 1) == r.charAt(n + 3) && l(r.charAt(n)) > l(r.charAt(n + 2)))
                    return;
                if (n - 1 >= 0 && l(r.charAt(n - 1)) < l(r.charAt(n + 1)))
                    return;
                t -= l(r.charAt(n))
            } else
                t += l(r.charAt(n));
            n--
        }
        return t
    }
    function h(r) {
        r = String(r).toUpperCase(),
        console.log("~ " + r);
        for (var e = "", t = "", n = "", o = 0, i = 0; i < r.length; )
            n == (t = r.charAt(i)) ? (o++,
            console.log("c: " + o),
            o > 2 && (e = "Römische Zahl ist inkorrekt: Nur 3 gleiche Zeichen in Folge erlaubt!")) : o = 0,
            n = t,
            i++;
        return e
    }
    function u(r) {
        for (var e = "", t = r.length - 1; t >= 0; ) {
            if (t + 1 <= r.length - 1 && !s(r.charAt(t + 1)) && r.charAt(t) == r.charAt(t + 1) && !s(r.charAt(t))) {
                var n = r.charAt(t + 1);
                e = "Zwei " + n + " dürfen nicht nebeneinander stehen!",
                "V" == n ? e += " Nutze stattdessen: X" : "L" == n ? e += " Nutze stattdessen: C" : "D" == n && (e += " Nutze stattdessen: M")
            }
            t--
        }
        return e
    }
    function s(r) {
        return "I" == r || "X" == r || "C" == r || "M" == r
    }
    function f(r) {
        r = String(r).toUpperCase(),
        error_msg = "";
        for (e = r.length - 1; e >= 0; ) {
            if (e + 2 <= r.length - 1 && r.charAt(e + 1) == r.charAt(e + 2) && !s(r.charAt(e + 1)))
                return error_msg = "Falsche Anordnung der Zahlzeichen (Beispiel: XCC muss als CXC geschrieben werden)",
                error_msg;
            if (e + 3 <= r.length - 1 && r.charAt(e + 1) == r.charAt(e + 3) && l(r.charAt(e + 1)) > l(r.charAt(e + 2)))
                return error_msg = "Falsche Anordnung der Zahlzeichen (Beispiel: [X]CIC)",
                error_msg;
            if (e - 1 >= 0 && l(r.charAt(e - 1)) < l(r.charAt(e + 1)))
                return error_msg = "Falsche Anordnung der Zahlzeichen (Beispiel: X[I]C)!",
                error_msg;
            e--
        }
        for (var e = r.length - 1; e >= 0; )
            e + 1 <= r.length - 1 && ("V" == r.charAt(e) && "X" == r.charAt(e + 1) ? error_msg = "V darf nicht vor X stehen! Meintest du XV?" : "V" == r.charAt(e) && "L" == r.charAt(e + 1) ? error_msg = "V darf nicht vor L stehen! Meintest du LV?" : "V" == r.charAt(e) && "C" == r.charAt(e + 1) ? error_msg = "V darf nicht vor C stehen! Meintest du CV?" : "V" == r.charAt(e) && "D" == r.charAt(e + 1) ? error_msg = "V darf nicht vor D stehen! Meintest du DV?" : "V" == r.charAt(e) && "M" == r.charAt(e + 1) ? error_msg = "V darf nicht vor M stehen! Meintest du MV?" : "L" == r.charAt(e) && "C" == r.charAt(e + 1) ? error_msg = "L darf nicht vor C stehen! Meintest du CL?" : "L" == r.charAt(e) && "D" == r.charAt(e + 1) ? error_msg = "L darf nicht vor D stehen! Meintest du DL?" : "L" == r.charAt(e) && "M" == r.charAt(e + 1) ? error_msg = "L darf nicht vor M stehen! Meintest du ML?" : "D" == r.charAt(e) && "M" == r.charAt(e + 1) ? error_msg = "D darf nicht vor M stehen! Meintest du MD?" : "I" == r.charAt(e) && "L" == r.charAt(e + 1) ? error_msg = "I darf nicht vor L stehen! 49 ist XLIX." : "I" == r.charAt(e) && "C" == r.charAt(e + 1) ? error_msg = "I darf nicht vor C stehen! 99 ist XCIX." : "I" == r.charAt(e) && "D" == r.charAt(e + 1) ? error_msg = "I darf nicht vor L stehen! 499 ist CDXCIX." : "I" == r.charAt(e) && "M" == r.charAt(e + 1) && (error_msg = "I darf nicht vor M stehen! 999 ist CMXCIX.")),
            e--;
        return error_msg
    }
    var g, d = Math.pow(10, 5), m = 47, b = "XLVII", v = (new Array,
    "val_a"), p = "", A = 21, C = "IVXLCDM", _ = (window.location.href,
    function() {
        var r = {};
        window.location.href.replace(/[?&]+([^=&]+)=?([^&]*)/gi, function(e, t, n) {
            r[t] = n
        });
        return r
    }()), k = [];
    if (Object.keys(_).length > 0) {
        var I = 0;
        $.each(_, function(r, e) {
            "a" == (r = r.toLowerCase()) ? (m = e,
            k.push("val_a")) : I--,
            I++
        }),
        I >= 0 && (v = "",
        e(),
        r(v = k[0]))
    }
    $(".formelblock input, .formelblock2 input").focus(function(e) {
        r($(this).attr("id"))
    }).blur(function(e) {
        r("nothing")
    }),
    $(".formelblock input, .formelblock2 input").keyup(function(e) {
        r($(this).attr("id"))
    }),
    $(".formelblock input").focus(function(e) {
        r($(this).attr("id")),
        $(".formelblock").trigger("keyup")
    }),
    $(".formelblock2 input").focus(function(e) {
        r($(this).attr("id")),
        $(".formelblock2").trigger("keyup")
    }),
    $(".formelblock").keyup(function(r) {
        if (37 != r.keyCode && 39 != r.keyCode)
            if (38 != r.keyCode)
                if (40 != r.keyCode) {
                    if (p = "",
                    $("#errormsg").html(""),
                    $("#errormsg").hide(),
                    $("#result_roman").html(""),
                    "val_a" == v) {
                        if ("" != $(this).find("#val_a").val()) {
                            if (m = Math.round(t($(this).find("#val_a").val())),
                            m = Math.abs(m),
                            isNaN(m))
                                return void (p = "Dies ist keine natürliche Zahl.");
                            0 == m ? ($("#val_b").val("-"),
                            p = "Die Römer hatten kein Zeichen für Null.") : String(m).length > 4 ? (m = parseInt(String(m).substring(0, 4)),
                            p = "Nicht mehr als " + (Math.pow(10, 4) - 1) + " eingeben!") : (b = i(m),
                            e(),
                            $("#val_b").val(b))
                        }
                    } else
                        "val_b" == v && (b = $(this).find("#val_b").val(),
                        b = String(b).toUpperCase(),
                        isNaN(b) && (resultNr = c(b),
                        void 0 == resultNr || isNaN(resultNr) ? $("#result_roman").text("-") : 0 != resultNr && $("#result_roman").text($("#result_roman").text() + resultNr + " "),
                        "" == p && (p = h(b)),
                        "" == p && (p = f(b)),
                        "" == p && (p = u(b))),
                        m = c(b),
                        $("#val_a").val(m),
                        e());
                    "" == p ? ($("#result_roman").html("Dezimal: " + m + " = Römisch: " + String(b).toUpperCase()),
                    $("#errormsg").html(""),
                    $("#errormsg").hide()) : ($("#result_roman").html(""),
                    $("#errormsg").html(p),
                    $("#errormsg").show()),
                    o()
                } else
                    n(v, !1);
            else
                n(v, !0)
    });
    ["(\\color{blue}{a} + \\color{red}{b})^2 = \\color{blue}{a}^2 + 2 \\cdot \\color{blue}{a} \\cdot \\color{red}{b} + \\color{red}{b}^2", "(\\color{blue}{a} + \\color{red}{b})^2 = \\color{blue}{a}^2 + 2 \\cdot \\color{blue}{a} \\cdot \\color{red}{b} + \\color{red}{b}^2"].slice(),
    ["(\\color{blue}{a} + \\color{red}{b}) \\cdot (\\color{blue}{a} – \\color{red}{b}) = \\color{blue}{a}^2 – \\color{red}{b}^2", "(\\color{blue}{a} + \\color{red}{b}) \\cdot (\\color{blue}{a} – \\color{red}{b}) = \\color{blue}{a}^2 – \\color{red}{b}^2"].slice();
    $("#memvaluelink").click(function(r) {
        return r.preventDefault(),
        $("#lightbox-popup").fadeIn("slow"),
        o(),
        $("#lightbox-center").html('<input type="text" class="linkshare" value="' + g + '" >'),
        $("#lightbox-center .linkshare").select(),
        $("#lightbox-center").css("margin-top", ($(window).height() - $("#lightbox-center").height()) / 2 + "px"),
        !1
    }),
    $("#lightbox-popup").click(function() {
        $("#lightbox-popup").fadeOut("fast")
    }),
    $(".formelblock").trigger("keyup")
});
