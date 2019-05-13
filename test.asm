global main
SECTION .text

array_size_func:
        mov     rax, [rdi]
        ret





default rel

global print_func
global println_func
global getString_func
global getInt_func
global toString_func
global _string_length_func
global _string_substring_func
global _string_parseInt_func
global _string_ord_func
global _string_add_func
global _string_less_func
global _string_lessequal_func
global _string_great_func
global _string_greaterequal_func
global _string_equal_func
global _string_notequal_func

extern strcmp
extern strcpy
extern strlen
extern malloc
extern __stack_chk_fail
extern __isoc99_scanf
extern puts
extern printf
extern _GLOBAL_OFFSET_TABLE_


SECTION .text   

print_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     rsi, rax
        lea     rdi, [rel L_017]
        mov     eax, 0
        call    printf
        nop
        leave
        ret


println_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     rdi, rax
        call    puts
        nop
        leave
        ret


getString_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     rax, qword [rbp-8H]
        mov     rsi, rax
        lea     rdi, [rel L_017]
        mov     eax, 0
        call    __isoc99_scanf
        mov     rax, qword [rbp-8H]
        leave
        ret


getInt_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16


        mov     rax, qword [fs:abs 28H]
        mov     qword [rbp-8H], rax
        xor     eax, eax
        lea     rax, [rbp-10H]
        mov     rsi, rax
        lea     rdi, [rel L_018]
        mov     eax, 0
        call    __isoc99_scanf
        mov     rax, qword [rbp-10H]
        mov     rdx, qword [rbp-8H]


        xor     rdx, qword [fs:abs 28H]
        jz      L_001
        call    __stack_chk_fail
L_001:  leave
        ret


toString_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 48
        mov     qword [rbp-28H], rdi
        mov     rax, qword [rbp-28H]
        mov     qword [rbp-20H], rax
        mov     qword [rbp-18H], 0
        cmp     qword [rbp-20H], 0
        jns     L_002
        add     qword [rbp-18H], 1
        neg     qword [rbp-20H]
L_002:  cmp     qword [rbp-20H], 0
        jnz     L_004
        add     qword [rbp-18H], 1
        jmp     L_004

L_003:  add     qword [rbp-18H], 1
        mov     rcx, qword [rbp-20H]
        mov     rdx, qword 6666666666666667H
        mov     rax, rcx
        imul    rdx
        sar     rdx, 2
        mov     rax, rcx
        sar     rax, 63
        sub     rdx, rax
        mov     rax, rdx
        mov     qword [rbp-20H], rax
L_004:  cmp     qword [rbp-20H], 0
        jnz     L_003
        mov     rax, qword [rbp-18H]
        add     rax, 1
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        cmp     qword [rbp-28H], 0
        jns     L_005
        mov     rax, qword [rbp-8H]
        mov     byte [rax], 45
        neg     qword [rbp-28H]
L_005:  cmp     qword [rbp-28H], 0
        jnz     L_006
        mov     rax, qword [rbp-8H]
        mov     byte [rax], 48
        mov     rax, qword [rbp-8H]
        jmp     L_011

L_006:  mov     rax, qword [rbp-18H]
        sub     rax, 1
        mov     qword [rbp-10H], rax
        jmp     L_008

L_007:  mov     rcx, qword [rbp-28H]
        mov     rdx, qword 6666666666666667H
        mov     rax, rcx
        imul    rdx
        sar     rdx, 2
        mov     rax, rcx
        sar     rax, 63
        sub     rdx, rax
        mov     rax, rdx
        shl     rax, 2
        add     rax, rdx
        add     rax, rax
        sub     rcx, rax
        mov     rdx, rcx
        mov     eax, edx
        lea     ecx, [rax+30H]
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     edx, ecx
        mov     byte [rax], dl
        mov     rcx, qword [rbp-28H]
        mov     rdx, qword 6666666666666667H
        mov     rax, rcx
        imul    rdx
        sar     rdx, 2
        mov     rax, rcx
        sar     rax, 63
        sub     rdx, rax
        mov     rax, rdx
        mov     qword [rbp-28H], rax
        cmp     qword [rbp-28H], 0
        jz      L_009
        sub     qword [rbp-10H], 1
L_008:  cmp     qword [rbp-10H], 0
        jns     L_007
        jmp     L_010

L_009:  nop
L_010:  mov     rax, qword [rbp-8H]
L_011:  leave
        ret


_string_length_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     rax, qword [rbp-8H]
        mov     rdi, rax
        call    strlen
        leave
        ret


_string_substring_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 64
        mov     qword [rbp-28H], rdi
        mov     qword [rbp-30H], rsi
        mov     qword [rbp-38H], rdx
        mov     rax, qword [rbp-38H]
        sub     rax, qword [rbp-30H]
        add     rax, 2
        mov     qword [rbp-10H], rax
        mov     rax, qword [rbp-10H]
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rax, qword [rbp-10H]
        lea     rdx, [rax-1H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-30H]
        mov     qword [rbp-18H], rax
        jmp     L_013

L_012:  mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-28H]
        lea     rcx, [rdx+rax]
        mov     rax, qword [rbp-18H]
        sub     rax, qword [rbp-30H]
        mov     rdx, rax
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        movzx   eax, byte [rcx]
        mov     byte [rdx], al
        add     qword [rbp-18H], 1
L_013:  mov     rax, qword [rbp-18H]
        cmp     rax, qword [rbp-38H]
        jle     L_012
        mov     rax, qword [rbp-8H]
        leave
        ret


_string_parseInt_func:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-18H], rdi
        mov     qword [rbp-10H], 0
        mov     rax, qword [rbp-18H]
        mov     qword [rbp-8H], rax
        jmp     L_015

L_014:  mov     rdx, qword [rbp-10H]
        mov     rax, rdx
        shl     rax, 2
        add     rax, rdx
        add     rax, rax
        mov     rdx, rax
        mov     rax, qword [rbp-8H]
        movzx   eax, byte [rax]
        movsx   rax, al
        add     rax, rdx
        sub     rax, 48
        mov     qword [rbp-10H], rax
        add     qword [rbp-8H], 1
L_015:  mov     rax, qword [rbp-8H]
        movzx   eax, byte [rax]
        cmp     al, 57
        jg      L_016
        mov     rax, qword [rbp-8H]
        movzx   eax, byte [rax]
        cmp     al, 47
        jg      L_014
L_016:  mov     rax, qword [rbp-10H]
        pop     rbp
        ret


_string_ord_func:
        push    rbp
        mov     rbp, rsp
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        movzx   eax, byte [rax]
        movsx   rax, al
        pop     rbp
        ret


_string_add_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 48
        mov     qword [rbp-28H], rdi
        mov     qword [rbp-30H], rsi
        mov     rax, qword [rbp-28H]
        mov     rdi, rax
        call    strlen
        mov     qword [rbp-18H], rax
        mov     rax, qword [rbp-30H]
        mov     rdi, rax
        call    strlen
        mov     qword [rbp-10H], rax
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-10H]
        add     rax, rdx
        add     rax, 1
        mov     rdi, rax
        call    malloc
        mov     qword [rbp-8H], rax
        mov     rdx, qword [rbp-28H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcpy
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-8H]
        add     rdx, rax
        mov     rax, qword [rbp-30H]
        mov     rsi, rax
        mov     rdi, rdx
        call    strcpy
        mov     rdx, qword [rbp-18H]
        mov     rax, qword [rbp-10H]
        add     rax, rdx
        mov     rdx, rax
        mov     rax, qword [rbp-8H]
        add     rax, rdx
        mov     byte [rax], 0
        mov     rax, qword [rbp-8H]
        leave
        ret


_string_less_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        shr     eax, 31
        leave
        ret


_string_lessequal_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setle   al
        leave
        ret


_string_great_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setg    al
        leave
        ret


_string_greaterequal_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        not     eax
        shr     eax, 31
        leave
        ret


_string_equal_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        sete    al
        leave
        ret


_string_notequal_func:
        push    rbp
        mov     rbp, rsp
        sub     rsp, 16
        mov     qword [rbp-8H], rdi
        mov     qword [rbp-10H], rsi
        mov     rdx, qword [rbp-10H]
        mov     rax, qword [rbp-8H]
        mov     rsi, rdx
        mov     rdi, rax
        call    strcmp
        test    eax, eax
        setne   al
        leave
        ret



SECTION .data   


SECTION .bss    


SECTION .rodata 

L_017:
        db 25H, 73H, 00H

L_018:
        db 25H, 6CH, 64H, 00H


section .text
main:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 32
Lab_1:
          mov       r10, 10100
          imul      r10, 8
          mov       qword [rbp-8], r10
          mov       r10, qword [rbp-8]
          add       r10, 8
          mov       qword [rbp-16], r10
          mov       rdi, qword [rbp-16]
          call      malloc
          mov       qword [rbp-24], rax
          mov       r10, 10100
          mov       r11, qword [rbp-24]
          mov       [r11], r10
          mov       r10, qword [rbp-24]
          mov       qword [@a_var], r10
          mov       r10, 10000
          mov       qword [@n_var], r10
          call      main_func
          leave     
          ret       

qsrt_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 656
          mov       qword [rbp-48], rdi
          mov       qword [rbp-40], rsi
Lab_2:
          mov       r10, qword [rbp-48]
          mov       qword [rbp-56], r10
          mov       r10, qword [rbp-56]
          mov       qword [rbp-32], r10
          mov       r10, qword [rbp-40]
          mov       qword [rbp-64], r10
          mov       r10, qword [rbp-64]
          mov       qword [rbp-24], r10
          mov       r10, qword [rbp-48]
          mov       qword [rbp-72], r10
          mov       r10, qword [rbp-40]
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-72]
          add       r10, qword [rbp-80]
          mov       qword [rbp-88], r10
          xor       rdx, rdx
          mov       rax, qword [rbp-88]
          idiv      2
          mov       qword [rbp-96], rax
          mov       r10, qword [@a_var]
          mov       qword [rbp-104], r10
          mov       r10, qword [rbp-96]
          imul      r10, 8
          mov       qword [rbp-112], r10
          mov       r10, qword [rbp-112]
          add       r10, 8
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-104]
          add       r10, qword [rbp-120]
          mov       qword [rbp-128], r10
          mov       r11, qword [rbp-128]
          mov       r10, [r11]
          mov       qword [rbp-136], r10
          mov       r10, qword [rbp-136]
          mov       qword [rbp-16], r10
          jmp       Lab_3
Lab_3:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-144], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-152], r10
          mov       r10, qword [rbp-144]
          cmp       r10, qword [rbp-152]
          xor       rax, rax
          setle     al
          mov       qword [rbp-160], rax
          cmp       qword [rbp-160], 0
          jnz       Lab_4
          jmp       Lab_5
Lab_4:
          jmp       Lab_6
Lab_5:
          jmp       Lab_16
Lab_6:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-168], r10
          mov       r10, qword [@a_var]
          mov       qword [rbp-176], r10
          mov       r10, qword [rbp-168]
          imul      r10, 8
          mov       qword [rbp-184], r10
          mov       r10, qword [rbp-184]
          add       r10, 8
          mov       qword [rbp-192], r10
          mov       r10, qword [rbp-176]
          add       r10, qword [rbp-192]
          mov       qword [rbp-200], r10
          mov       r11, qword [rbp-200]
          mov       r10, [r11]
          mov       qword [rbp-208], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-216], r10
          mov       r10, qword [rbp-208]
          cmp       r10, qword [rbp-216]
          xor       rax, rax
          setl      al
          mov       qword [rbp-224], rax
          cmp       qword [rbp-224], 0
          jnz       Lab_7
          jmp       Lab_8
Lab_7:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-232], r10
          mov       r10, qword [rbp-232]
          add       r10, 1
          mov       qword [rbp-240], r10
          mov       r10, qword [rbp-240]
          mov       qword [rbp-32], r10
          jmp       Lab_6
Lab_8:
          jmp       Lab_9
Lab_9:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-248], r10
          mov       r10, qword [@a_var]
          mov       qword [rbp-256], r10
          mov       r10, qword [rbp-248]
          imul      r10, 8
          mov       qword [rbp-264], r10
          mov       r10, qword [rbp-264]
          add       r10, 8
          mov       qword [rbp-272], r10
          mov       r10, qword [rbp-256]
          add       r10, qword [rbp-272]
          mov       qword [rbp-280], r10
          mov       r11, qword [rbp-280]
          mov       r10, [r11]
          mov       qword [rbp-288], r10
          mov       r10, qword [rbp-16]
          mov       qword [rbp-296], r10
          mov       r10, qword [rbp-288]
          cmp       r10, qword [rbp-296]
          xor       rax, rax
          setg      al
          mov       qword [rbp-304], rax
          cmp       qword [rbp-304], 0
          jnz       Lab_10
          jmp       Lab_11
Lab_10:
          mov       r10, qword [rbp-24]
          mov       qword [rbp-312], r10
          mov       r10, qword [rbp-312]
          sub       r10, 1
          mov       qword [rbp-320], r10
          mov       r10, qword [rbp-320]
          mov       qword [rbp-24], r10
          jmp       Lab_9
Lab_11:
          jmp       Lab_12
Lab_12:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-328], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-336], r10
          mov       r10, qword [rbp-328]
          cmp       r10, qword [rbp-336]
          xor       rax, rax
          setle     al
          mov       qword [rbp-344], rax
          cmp       qword [rbp-344], 0
          jnz       Lab_13
          jmp       Lab_14
Lab_13:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-352], r10
          mov       r10, qword [@a_var]
          mov       qword [rbp-360], r10
          mov       r10, qword [rbp-352]
          imul      r10, 8
          mov       qword [rbp-368], r10
          mov       r10, qword [rbp-368]
          add       r10, 8
          mov       qword [rbp-376], r10
          mov       r10, qword [rbp-360]
          add       r10, qword [rbp-376]
          mov       qword [rbp-384], r10
          mov       r11, qword [rbp-384]
          mov       r10, [r11]
          mov       qword [rbp-392], r10
          mov       r10, qword [rbp-392]
          mov       qword [rbp-8], r10
          mov       r10, qword [rbp-32]
          mov       qword [rbp-400], r10
          mov       r10, qword [@a_var]
          mov       qword [rbp-408], r10
          mov       r10, qword [rbp-400]
          imul      r10, 8
          mov       qword [rbp-416], r10
          mov       r10, qword [rbp-416]
          add       r10, 8
          mov       qword [rbp-424], r10
          mov       r10, qword [rbp-408]
          add       r10, qword [rbp-424]
          mov       qword [rbp-432], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-440], r10
          mov       r10, qword [@a_var]
          mov       qword [rbp-448], r10
          mov       r10, qword [rbp-440]
          imul      r10, 8
          mov       qword [rbp-456], r10
          mov       r10, qword [rbp-456]
          add       r10, 8
          mov       qword [rbp-464], r10
          mov       r10, qword [rbp-448]
          add       r10, qword [rbp-464]
          mov       qword [rbp-472], r10
          mov       r11, qword [rbp-472]
          mov       r10, [r11]
          mov       qword [rbp-480], r10
          mov       r10, qword [rbp-480]
          mov       r11, qword [rbp-432]
          mov       [r11], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-488], r10
          mov       r10, qword [@a_var]
          mov       qword [rbp-496], r10
          mov       r10, qword [rbp-488]
          imul      r10, 8
          mov       qword [rbp-504], r10
          mov       r10, qword [rbp-504]
          add       r10, 8
          mov       qword [rbp-512], r10
          mov       r10, qword [rbp-496]
          add       r10, qword [rbp-512]
          mov       qword [rbp-520], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-528], r10
          mov       r10, qword [rbp-528]
          mov       r11, qword [rbp-520]
          mov       [r11], r10
          mov       r10, qword [rbp-32]
          mov       qword [rbp-536], r10
          mov       r10, qword [rbp-536]
          add       r10, 1
          mov       qword [rbp-544], r10
          mov       r10, qword [rbp-544]
          mov       qword [rbp-32], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-552], r10
          mov       r10, qword [rbp-552]
          sub       r10, 1
          mov       qword [rbp-560], r10
          mov       r10, qword [rbp-560]
          mov       qword [rbp-24], r10
Lab_14:
Lab_15:
          jmp       Lab_3
Lab_16:
          mov       r10, qword [rbp-48]
          mov       qword [rbp-568], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-576], r10
          mov       r10, qword [rbp-568]
          cmp       r10, qword [rbp-576]
          xor       rax, rax
          setl      al
          mov       qword [rbp-584], rax
          cmp       qword [rbp-584], 0
          jnz       Lab_17
          jmp       Lab_18
Lab_17:
          mov       r10, qword [rbp-48]
          mov       qword [rbp-592], r10
          mov       r10, qword [rbp-24]
          mov       qword [rbp-600], r10
          mov       rdi, qword [rbp-592]
          mov       rsi, qword [rbp-600]
          call      qsrt_func
          mov       qword [rbp-608], rax
Lab_18:
Lab_19:
          jmp       Lab_20
Lab_20:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-616], r10
          mov       r10, qword [rbp-40]
          mov       qword [rbp-624], r10
          mov       r10, qword [rbp-616]
          cmp       r10, qword [rbp-624]
          xor       rax, rax
          setl      al
          mov       qword [rbp-632], rax
          cmp       qword [rbp-632], 0
          jnz       Lab_21
          jmp       Lab_22
Lab_21:
          mov       r10, qword [rbp-32]
          mov       qword [rbp-640], r10
          mov       r10, qword [rbp-40]
          mov       qword [rbp-648], r10
          mov       rdi, qword [rbp-640]
          mov       rsi, qword [rbp-648]
          call      qsrt_func
          mov       qword [rbp-656], rax
Lab_22:
Lab_23:
          mov       rax, 0
          leave     
          ret       
          leave     
          ret       

main_func:
          push      rbp
          mov       rbp, rsp
          sub       rsp, 240
Lab_24:
          mov       r10, 1
          mov       qword [rbp-8], r10
          jmp       Lab_25
Lab_25:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-16], r10
          mov       r10, qword [@n_var]
          mov       qword [rbp-24], r10
          mov       r10, qword [rbp-16]
          cmp       r10, qword [rbp-24]
          xor       rax, rax
          setle     al
          mov       qword [rbp-32], rax
          cmp       qword [rbp-32], 0
          jnz       Lab_26
          jmp       Lab_27
Lab_26:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-40], r10
          mov       r10, qword [@a_var]
          mov       qword [rbp-48], r10
          mov       r10, qword [rbp-40]
          imul      r10, 8
          mov       qword [rbp-56], r10
          mov       r10, qword [rbp-56]
          add       r10, 8
          mov       qword [rbp-64], r10
          mov       r10, qword [rbp-48]
          add       r10, qword [rbp-64]
          mov       qword [rbp-72], r10
          mov       r10, qword [@n_var]
          mov       qword [rbp-80], r10
          mov       r10, qword [rbp-80]
          add       r10, 1
          mov       qword [rbp-88], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-96], r10
          mov       r10, qword [rbp-88]
          sub       r10, qword [rbp-96]
          mov       qword [rbp-104], r10
          mov       r10, qword [rbp-104]
          mov       r11, qword [rbp-72]
          mov       [r11], r10
          mov       r10, qword [rbp-8]
          mov       qword [rbp-112], r10
          mov       r10, qword [rbp-112]
          add       r10, 1
          mov       qword [rbp-120], r10
          mov       r10, qword [rbp-120]
          mov       qword [rbp-8], r10
          jmp       Lab_25
Lab_27:
          mov       r10, qword [@n_var]
          mov       qword [rbp-128], r10
          mov       rdi, 1
          mov       rsi, qword [rbp-128]
          call      qsrt_func
          mov       qword [rbp-136], rax
          mov       r10, 1
          mov       qword [rbp-8], r10
          jmp       Lab_28
Lab_28:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-144], r10
          mov       r10, qword [@n_var]
          mov       qword [rbp-152], r10
          mov       r10, qword [rbp-144]
          cmp       r10, qword [rbp-152]
          xor       rax, rax
          setle     al
          mov       qword [rbp-160], rax
          cmp       qword [rbp-160], 0
          jnz       Lab_29
          jmp       Lab_30
Lab_29:
          mov       r10, qword [rbp-8]
          mov       qword [rbp-168], r10
          mov       r10, qword [@a_var]
          mov       qword [rbp-176], r10
          mov       r10, qword [rbp-168]
          imul      r10, 8
          mov       qword [rbp-184], r10
          mov       r10, qword [rbp-184]
          add       r10, 8
          mov       qword [rbp-192], r10
          mov       r10, qword [rbp-176]
          add       r10, qword [rbp-192]
          mov       qword [rbp-200], r10
          mov       r11, qword [rbp-200]
          mov       r10, [r11]
          mov       qword [rbp-208], r10
          mov       rdi, qword [rbp-208]
          call      toString_func
          mov       qword [rbp-216], rax
          mov       rdi, qword [rbp-216]
          call      print_func
          mov       rdi, const_1_cs
          call      print_func
          mov       r10, qword [rbp-8]
          mov       qword [rbp-224], r10
          mov       r10, qword [rbp-224]
          add       r10, 1
          mov       qword [rbp-232], r10
          mov       r10, qword [rbp-232]
          mov       qword [rbp-8], r10
          jmp       Lab_28
Lab_30:
          mov       rdi, const_2_cs
          call      print_func
          mov       rax, 0
          leave     
          ret       
          leave     
          ret       


section .data
const_1_cs:
          db        32,0     ; 
const_2_cs:
          db        10,0     ;\n
section .bss
@a_var:
          resb      8
@n_var:
          resb      8
