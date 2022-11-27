package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс обеспечивает работу с данными банка о клиентах и их счетах.
 * @author PAVEL YATSULA
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение клиентов осуществляется в коллекции типа HashMap,
     * поля которой являются коллекциями типа ArrayList, в которой
     * хранятся счета клиента.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход клиента и добавляет в карту запись
     * с пустым списком счетов, если в карте еще нет такого клиента.
     * @param user клиент, которого пытаемся добавить в карту.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход номер паспорта клиента и удаляет
     * из карты запись этого клиента.
     * @param passport номер паспорта клиента.
     * @return возвращает true, если клиент успешно удален или
     * false, если такого клиента не было в карте.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, "")) != null;
    }

    /**
     * Метод принимает номер паспорта клиента и счет и добавляет
     * счет в список счетов клиента, если клиент с таким номером
     * паспорта есть в карте и в его списке счетов еще нет такого
     * счета.
     * @param passport номер паспорта клиента
     * @param account счет, который добавляется в список счетов клиента.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List userAccounts = users.get(user);
            if (!userAccounts.contains(account)) {
                userAccounts.add(account);
            }
        }
    }

    /**
     * Метод принимает номер паспорта клиента
     * и возвращает клиента, если он есть в карте.
     * @param passport номер паспорта клиента
     * @return возвращает клиента (класс User), если клиент есть в карте,
     * или null.
     */
    public User findByPassport(String passport) {
        User user = new User(passport, "");
        for (User u : users.keySet()) {
            if (u.equals(user)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Метод принимает номер паспорта клиента и реквизиты счета
     * и возвращает счет.
     * @param passport номер паспорта клиента
     * @param requisite реквизиты счета
     * @return вовзращает счет клиента, если клиент есть в карте и
     * счет с такими реквизитами существует, или null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account account = new Account(requisite, 0);
        if (user != null) {
            for (Account acc : users.get(user)) {
                if (acc.equals(account)) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Метод получает номера паспортов и реквизиты счетов отправителя и
     * получателя, проверяет наличие таких клиентов и счетов, списывает
     * сумму перевода со счета отправителя и добавляет к счету получателя,
     * если на счете отправителя достаточно средств.
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite реквизиты счета отправителя
     * @param destPassport паспорт получателя
     * @param destRequisite реквизиты счет получателя
     * @param amount сумма перевода
     * @return возвращает true если перевод прошел успешно,
     * возвращает false, если перевод не удался.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод получает клиента и возвращает список счетов
     * этого клиента.
     * @param user клиент (класс User)
     * @return возвращает список счетов клиента.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
